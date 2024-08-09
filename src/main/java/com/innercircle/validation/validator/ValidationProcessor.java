package com.innercircle.validation.validator;

import com.google.auto.service.AutoService;
import com.innercircle.validation.annotation.BaseValidation;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.tools.Diagnostic;
import java.util.Set;
import java.util.regex.Pattern;

@AutoService(Processor.class)
@SupportedAnnotationTypes({
        "com.example.PhoneNumber",
        "com.example.CreditCardNumber"
})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class ValidationProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(BaseValidation.class)) {

            BaseValidation validation = element.getAnnotation(BaseValidation.class);
            if (validation != null) {
                String pattern = validation.pattern();
                String message = validation.message();

                if (element.getKind() == ElementKind.FIELD) {
                    VariableElement variableElement = (VariableElement) element;

                    if (!variableElement.asType().toString().equals(String.class.getCanonicalName())) {
                        processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                                "@BaseValidation can only be applied to String fields", element);
                    } else {
                        String fieldValue = (String) variableElement.getConstantValue();
                        if (fieldValue != null && !Pattern.matches(pattern, fieldValue)) {
                            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                                    message + " - Expected pattern: " + pattern, element);
                        }
                    }
                }
            }
        }
        return true;
    }
}
