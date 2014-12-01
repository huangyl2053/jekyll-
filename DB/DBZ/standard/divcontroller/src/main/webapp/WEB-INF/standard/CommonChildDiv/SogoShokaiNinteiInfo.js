var DBZ;
(function (DBZ) {
    (function (SogoShokaiNinteiInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        SogoShokaiNinteiInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SogoShokaiNinteiInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SogoShokaiNinteiInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SogoShokaiNinteiInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SogoShokaiNinteiInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtNinteiShinseiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiShinseiYMD"));
            };

            Controls.prototype.txtNinteiShinseiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiShinseiKubun"));
            };

            Controls.prototype.txtNinteiYukoKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiYukoKubun"));
            };

            Controls.prototype.txtNinteiChosaJissiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiChosaJissiYMD"));
            };

            Controls.prototype.txtNinteiChosaJuryoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiChosaJuryoYMD"));
            };

            Controls.prototype.txtNinteiChosaKanryoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiChosaKanryoYMD"));
            };

            Controls.prototype.txtNinteiChosaItakusaki = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiChosaItakusaki"));
            };

            Controls.prototype.txtNinteiChosain = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiChosain"));
            };

            Controls.prototype.txtNinteiShujiiIryoKikan = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiShujiiIryoKikan"));
            };

            Controls.prototype.txtNinteiShujii = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiShujii"));
            };

            Controls.prototype.txtNinteiIkenshoJuryoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiIkenshoJuryoYMD"));
            };

            Controls.prototype.txtNinteiIkenshoKanryoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiIkenshoKanryoYMD"));
            };

            Controls.prototype.txtNinteiIchijiHantei = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiIchijiHantei"));
            };

            Controls.prototype.txtNinteiIchijiHanteiNinchi = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiIchijiHanteiNinchi"));
            };

            Controls.prototype.txtNinteiIchijiHanteiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiIchijiHanteiYMD"));
            };

            Controls.prototype.txtNinteiIchijiKanryoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiIchijiKanryoYMD"));
            };

            Controls.prototype.txtNinteiNinteiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiNinteiYMD"));
            };

            Controls.prototype.txtNinteiJotaiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiJotaiKubun"));
            };

            Controls.prototype.txtNinteiYukoKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNinteiYukoKikan"));
            };

            Controls.prototype.txtNinteiIdoJiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiIdoJiyu"));
            };

            Controls.prototype.txtNinteiIdoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiIdoYMD"));
            };

            Controls.prototype.txtNinteiSoshitsuYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiSoshitsuYMD"));
            };

            Controls.prototype.txtNinteiTorikeshiRiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiTorikeshiRiyu"));
            };

            Controls.prototype.txtNinteiTorikeshiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiTorikeshiYMD"));
            };

            Controls.prototype.txtNinteiTokuteiShippei = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiTokuteiShippei"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        SogoShokaiNinteiInfo.Controls = Controls;
    })(DBZ.SogoShokaiNinteiInfo || (DBZ.SogoShokaiNinteiInfo = {}));
    var SogoShokaiNinteiInfo = DBZ.SogoShokaiNinteiInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SogoShokaiNinteiInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SogoShokaiNinteiInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SogoShokaiNinteiInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SogoShokaiNinteiInfo.ModeController = ModeController;
    })(DBZ.SogoShokaiNinteiInfo || (DBZ.SogoShokaiNinteiInfo = {}));
    var SogoShokaiNinteiInfo = DBZ.SogoShokaiNinteiInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SogoShokaiNinteiInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SogoShokaiNinteiInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SogoShokaiNinteiInfo.PublicProperties = PublicProperties;
    })(DBZ.SogoShokaiNinteiInfo || (DBZ.SogoShokaiNinteiInfo = {}));
    var SogoShokaiNinteiInfo = DBZ.SogoShokaiNinteiInfo;
})(DBZ || (DBZ = {}));
