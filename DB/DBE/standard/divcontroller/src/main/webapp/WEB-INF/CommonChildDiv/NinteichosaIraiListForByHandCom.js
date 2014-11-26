var DBE;
(function (DBE) {
    (function (NinteichosaIraiListForByHandCom) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteichosaIraiListForByHandCom.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        NinteichosaIraiListForByHandCom.ModeController = ModeController;
    })(DBE.NinteichosaIraiListForByHandCom || (DBE.NinteichosaIraiListForByHandCom = {}));
    var NinteichosaIraiListForByHandCom = DBE.NinteichosaIraiListForByHandCom;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (NinteichosaIraiListForByHandCom) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new NinteichosaIraiListForByHandCom.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("onSort", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onSelect", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onSelectByDblClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onOnlyRow", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onNoRow", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onMultiRows", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("height", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("withOfGrid", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.getonSort = function () {
                return this.controls.dgNinteichosaIraiListForByHand().onSort;
            };

            PublicProperties.prototype.setonSort = function (value) {
                this.controls.dgNinteichosaIraiListForByHand().onSort = value;
            };

            PublicProperties.prototype.getonSelect = function () {
                return this.controls.dgNinteichosaIraiListForByHand().onSelect;
            };

            PublicProperties.prototype.setonSelect = function (value) {
                this.controls.dgNinteichosaIraiListForByHand().onSelect = value;
            };

            PublicProperties.prototype.getonSelectByDblClick = function () {
                return this.controls.dgNinteichosaIraiListForByHand().onSelectByDblClick;
            };

            PublicProperties.prototype.setonSelectByDblClick = function (value) {
                this.controls.dgNinteichosaIraiListForByHand().onSelectByDblClick = value;
            };

            PublicProperties.prototype.getonOnlyRow = function () {
                return this.controls.dgNinteichosaIraiListForByHand().onOnlyRow;
            };

            PublicProperties.prototype.setonOnlyRow = function (value) {
                this.controls.dgNinteichosaIraiListForByHand().onOnlyRow = value;
            };

            PublicProperties.prototype.getonNoRow = function () {
                return this.controls.dgNinteichosaIraiListForByHand().onNoRow;
            };

            PublicProperties.prototype.setonNoRow = function (value) {
                this.controls.dgNinteichosaIraiListForByHand().onNoRow = value;
            };

            PublicProperties.prototype.getonMultiRows = function () {
                return this.controls.dgNinteichosaIraiListForByHand().onMultiRows;
            };

            PublicProperties.prototype.setonMultiRows = function (value) {
                this.controls.dgNinteichosaIraiListForByHand().onMultiRows = value;
            };

            PublicProperties.prototype.getheight = function () {
                return this.controls.dgNinteichosaIraiListForByHand().height;
            };

            PublicProperties.prototype.setheight = function (value) {
                this.controls.dgNinteichosaIraiListForByHand().height = value;
            };

            PublicProperties.prototype.getwithOfGrid = function () {
                return this.controls.dgNinteichosaIraiListForByHand().width;
            };

            PublicProperties.prototype.setwithOfGrid = function (value) {
                this.controls.dgNinteichosaIraiListForByHand().width = value;
            };
            return PublicProperties;
        })();
        NinteichosaIraiListForByHandCom.PublicProperties = PublicProperties;
    })(DBE.NinteichosaIraiListForByHandCom || (DBE.NinteichosaIraiListForByHandCom = {}));
    var NinteichosaIraiListForByHandCom = DBE.NinteichosaIraiListForByHandCom;
})(DBE || (DBE = {}));
