package consorsbank.controllers;

import consorsbank.model.Wkn;

/**
 * Receive the currently selected WKN from the MainController.
 */
public interface WknSelectionAware {

    /**
     * Apply the selected WKN.
     *
     * @param wkn selected WKN
     */
    void setSelectedWkn(Wkn wkn);
}
