var DBZ;
(function (DBZ) {
    (function (OtherTokureiShisetsuInputGuide) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnSearchOtherShisetsu = function () {
                return "onClick_btnSearchOtherShisetsu";
            };

            Events.onSelectBySelectButton_dgSearchResultOtherTokureiShisetsu = function () {
                return "onSelectBySelectButton_dgSearchResultOtherTokureiShisetsu";
            };

            Events.onClick_btnOtherShisetsuReturn = function () {
                return "onClick_btnOtherShisetsuReturn";
            };
            return Events;
        })();
        OtherTokureiShisetsuInputGuide.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "OtherTokureiShisetsuInputGuide";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.OtherTokureiShisetsuInputGuide.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.OtherTokureiShisetsuInputGuide.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.OtherTokureiShisetsuInputGuide = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.radKannaiKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radKannaiKubun"));
            };

            Controls.prototype.btnSearchOtherShisetsu = function () {
                return new UZA.Button(this.convFiledName("btnSearchOtherShisetsu"));
            };

            Controls.prototype.lblOtherShisetsuShurui = function () {
                return new UZA.Label(this.convFiledName("lblOtherShisetsuShurui"));
            };

            Controls.prototype.SearchResultOtherShisetsu = function () {
                return new UZA.Panel(this.convFiledName("SearchResultOtherShisetsu"));
            };

            Controls.prototype.dgSearchResultOtherTokureiShisetsu = function () {
                return new UZA.DataGrid(this.convFiledName("dgSearchResultOtherTokureiShisetsu"));
            };

            Controls.prototype.btnOtherShisetsuReturn = function () {
                return new UZA.Button(this.convFiledName("btnOtherShisetsuReturn"));
            };
            return Controls;
        })();
        OtherTokureiShisetsuInputGuide.Controls = Controls;
    })(DBZ.OtherTokureiShisetsuInputGuide || (DBZ.OtherTokureiShisetsuInputGuide = {}));
    var OtherTokureiShisetsuInputGuide = DBZ.OtherTokureiShisetsuInputGuide;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (OtherTokureiShisetsuInputGuide) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new OtherTokureiShisetsuInputGuide.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new OtherTokureiShisetsuInputGuide.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        OtherTokureiShisetsuInputGuide.ModeController = ModeController;
    })(DBZ.OtherTokureiShisetsuInputGuide || (DBZ.OtherTokureiShisetsuInputGuide = {}));
    var OtherTokureiShisetsuInputGuide = DBZ.OtherTokureiShisetsuInputGuide;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (OtherTokureiShisetsuInputGuide) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new OtherTokureiShisetsuInputGuide.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        OtherTokureiShisetsuInputGuide.PublicProperties = PublicProperties;
    })(DBZ.OtherTokureiShisetsuInputGuide || (DBZ.OtherTokureiShisetsuInputGuide = {}));
    var OtherTokureiShisetsuInputGuide = DBZ.OtherTokureiShisetsuInputGuide;
})(DBZ || (DBZ = {}));
