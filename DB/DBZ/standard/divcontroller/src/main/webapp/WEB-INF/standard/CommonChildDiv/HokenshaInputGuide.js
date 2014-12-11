var DBZ;
(function (DBZ) {
    (function (HokenshaInputGuide) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnSearchGaitoHokensha = function () {
                return "onClick_btnSearchGaitoHokensha";
            };

            Events.onSelectBySelectButton_dgSearchResultHokensha = function () {
                return "onSelectBySelectButton_dgSearchResultHokensha";
            };

            Events.onClick_btnHokenshaReturn = function () {
                return "onClick_btnHokenshaReturn";
            };
            return Events;
        })();
        HokenshaInputGuide.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "HokenshaInputGuide";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.HokenshaInputGuide.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.HokenshaInputGuide.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.HokenshaInputGuide = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlHokenshaKenCode = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHokenshaKenCode"));
            };

            Controls.prototype.btnSearchGaitoHokensha = function () {
                return new UZA.Button(this.convFiledName("btnSearchGaitoHokensha"));
            };

            Controls.prototype.SearchResultHokensha = function () {
                return new UZA.Panel(this.convFiledName("SearchResultHokensha"));
            };

            Controls.prototype.dgSearchResultHokensha = function () {
                return new UZA.DataGrid(this.convFiledName("dgSearchResultHokensha"));
            };

            Controls.prototype.btnHokenshaReturn = function () {
                return new UZA.Button(this.convFiledName("btnHokenshaReturn"));
            };
            return Controls;
        })();
        HokenshaInputGuide.Controls = Controls;
    })(DBZ.HokenshaInputGuide || (DBZ.HokenshaInputGuide = {}));
    var HokenshaInputGuide = DBZ.HokenshaInputGuide;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (HokenshaInputGuide) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HokenshaInputGuide.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new HokenshaInputGuide.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        HokenshaInputGuide.ModeController = ModeController;
    })(DBZ.HokenshaInputGuide || (DBZ.HokenshaInputGuide = {}));
    var HokenshaInputGuide = DBZ.HokenshaInputGuide;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (HokenshaInputGuide) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new HokenshaInputGuide.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        HokenshaInputGuide.PublicProperties = PublicProperties;
    })(DBZ.HokenshaInputGuide || (DBZ.HokenshaInputGuide = {}));
    var HokenshaInputGuide = DBZ.HokenshaInputGuide;
})(DBZ || (DBZ = {}));
