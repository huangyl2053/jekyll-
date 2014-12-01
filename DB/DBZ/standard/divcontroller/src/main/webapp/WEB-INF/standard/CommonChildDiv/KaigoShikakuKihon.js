var DBZ;
(function (DBZ) {
    (function (KaigoShikakuKihon) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoShikakuKihon.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoShikakuKihon";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoShikakuKihon.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoShikakuKihon.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoShikakuKihon = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtHihokenshaNo = function () {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaNo"));
            };

            Controls.prototype.txtShutokuYmd = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShutokuYmd"));
            };

            Controls.prototype.txtShutokuJiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtShutokuJiyu"));
            };

            Controls.prototype.txtSoshitsuYmd = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSoshitsuYmd"));
            };

            Controls.prototype.txtSoshitsuJiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtSoshitsuJiyu"));
            };

            Controls.prototype.txtJutokuKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtJutokuKubun"));
            };

            Controls.prototype.txtYokaigoJotaiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtYokaigoJotaiKubun"));
            };

            Controls.prototype.txtNinteiKaishiYmd = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiKaishiYmd"));
            };

            Controls.prototype.txtNinteiShuryoYmd = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiShuryoYmd"));
            };

            Controls.prototype.btnNinteiRireki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnNinteiRireki"));
            };

            Controls.prototype.btnHihoRireki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnHihoRireki"));
            };

            Controls.prototype.btnRenrakusaki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnRenrakusaki"));
            };
            return Controls;
        })();
        KaigoShikakuKihon.Controls = Controls;
    })(DBZ.KaigoShikakuKihon || (DBZ.KaigoShikakuKihon = {}));
    var KaigoShikakuKihon = DBZ.KaigoShikakuKihon;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KaigoShikakuKihon) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoShikakuKihon.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoShikakuKihon.PublicProperties(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "RenrakusakiAriMode",
                    "HihokenrirekiNashiMode",
                    "NinteirirekiNashiMode"
                ];
            };

            ModeController.prototype.RenrakusakiAriMode = function () {
                return new Modes.RenrakusakiAriMode(this.controls);
            };

            ModeController.prototype.HihokenrirekiNashiMode = function () {
                return new Modes.HihokenrirekiNashiMode(this.controls);
            };

            ModeController.prototype.NinteirirekiNashiMode = function () {
                return new Modes.NinteirirekiNashiMode(this.controls);
            };
            return ModeController;
        })();
        KaigoShikakuKihon.ModeController = ModeController;

        (function (Modes) {
            var RenrakusakiAriMode = (function () {
                function RenrakusakiAriMode(controls) {
                    this.controls = controls;
                }
                RenrakusakiAriMode.prototype.RenrakusakiAri = function () {
                    this.controls.btnRenrakusaki().displayNone = false;
                };
                return RenrakusakiAriMode;
            })();
            Modes.RenrakusakiAriMode = RenrakusakiAriMode;

            var HihokenrirekiNashiMode = (function () {
                function HihokenrirekiNashiMode(controls) {
                    this.controls = controls;
                }
                HihokenrirekiNashiMode.prototype.HihokenrirekiNashi = function () {
                    this.controls.btnHihoRireki().displayNone = true;
                };
                return HihokenrirekiNashiMode;
            })();
            Modes.HihokenrirekiNashiMode = HihokenrirekiNashiMode;

            var NinteirirekiNashiMode = (function () {
                function NinteirirekiNashiMode(controls) {
                    this.controls = controls;
                }
                NinteirirekiNashiMode.prototype.NinteirirekiAri = function () {
                    this.controls.btnNinteiRireki().displayNone = true;
                };
                return NinteirirekiNashiMode;
            })();
            Modes.NinteirirekiNashiMode = NinteirirekiNashiMode;
        })(KaigoShikakuKihon.Modes || (KaigoShikakuKihon.Modes = {}));
        var Modes = KaigoShikakuKihon.Modes;
    })(DBZ.KaigoShikakuKihon || (DBZ.KaigoShikakuKihon = {}));
    var KaigoShikakuKihon = DBZ.KaigoShikakuKihon;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoShikakuKihon) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KaigoShikakuKihon.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoShikakuKihon.PublicProperties = PublicProperties;
    })(DBZ.KaigoShikakuKihon || (DBZ.KaigoShikakuKihon = {}));
    var KaigoShikakuKihon = DBZ.KaigoShikakuKihon;
})(DBZ || (DBZ = {}));
