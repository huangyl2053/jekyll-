var DBZ;
(function (DBZ) {
    (function (RirekiShusei) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new RirekiShusei.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new RirekiShusei.PublicProperties(this.fieldName);
            };
            ModeController.prototype.DisplayType = function () {
                return new Modes.DisplayType(this.controls);
            };
            return ModeController;
        })();
        RirekiShusei.ModeController = ModeController;

        (function (Modes) {
            var DisplayType = (function () {
                function DisplayType(controls) {
                    this.controls = controls;
                }
                DisplayType.prototype.sakujo = function () {
                    this.controls.ccdKaigoNinteiShinseiKihonJohoInput().InputType().ShokaiMode();
                    this.controls.ccdNinteiShinseiTodokedesha().ShoriType().ShokaiMode();
                    this.controls.ccdShujiiIryokikanAndShujiiInput().ShoriType().ShokaiMode();
                    this.controls.ccdChosaItakusakiAndChosainInput().ShoriType().ShokaiMode();
                    this.controls.ccdNinteiJohoInput().ShoriType().ShokaiMode();
                    this.controls.ccdZenkaiNinteiKekka().ShokaiButtonType().ShokaiButtonNoneMode();
                    this.controls.ccdShinseiSonotaJohoInput().ShoriType().TokushuSakujoMode();
                    this.controls.btnChosaJokyo().disabled = false;
                    this.controls.btnCancel().disabled = false;
                    this.controls.btnKakutei().disabled = false;
                };
                DisplayType.prototype.sakujoRirekiShusei = function () {
                    this.controls.ccdKaigoNinteiShinseiKihonJohoInput().InputType().RirekiShuseiMode();
                    this.controls.ccdNinteiShinseiTodokedesha().ShoriType().ShokaiMode();
                    this.controls.ccdShujiiIryokikanAndShujiiInput().ShoriType().ShokaiMode();
                    this.controls.ccdChosaItakusakiAndChosainInput().ShoriType().ShokaiMode();
                    this.controls.ccdNinteiJohoInput().ShoriType().ShokaiMode();
                    this.controls.ccdZenkaiNinteiKekka().ShokaiButtonType().ShokaiButtonNoneMode();
                    this.controls.ccdShinseiSonotaJohoInput().ShoriType().RirekiSakujoShusei();
                    this.controls.btnChosaJokyo().disabled = false;
                    this.controls.btnCancel().disabled = false;
                    this.controls.btnKakutei().disabled = false;
                };
                DisplayType.prototype.idoJiyuSentaku = function () {
                    this.controls.ccdKaigoNinteiShinseiKihonJohoInput().InputType().ShokaiMode();
                    this.controls.ccdNinteiShinseiTodokedesha().ShoriType().ShokaiMode();
                    this.controls.ccdShujiiIryokikanAndShujiiInput().ShoriType().ShokaiMode();
                    this.controls.ccdChosaItakusakiAndChosainInput().ShoriType().ShokaiMode();
                    this.controls.ccdNinteiJohoInput().ShoriType().ShokaiMode();
                    this.controls.ccdZenkaiNinteiKekka().ShokaiButtonType().ShokaiButtonNoneMode();
                    this.controls.ccdShinseiSonotaJohoInput().ShoriType().RirekiTsuika();
                    this.controls.btnChosaJokyo().disabled = false;
                    this.controls.btnCancel().disabled = false;
                    this.controls.btnKakutei().disabled = true;
                };
                DisplayType.prototype.torikeshiRirekiTsuika = function () {
                    this.controls.ccdKaigoNinteiShinseiKihonJohoInput().InputType().ShokaiMode();
                    this.controls.ccdNinteiShinseiTodokedesha().ShoriType().InputMode();
                    this.controls.ccdShujiiIryokikanAndShujiiInput().ShoriType().SimpleShokaiMode();
                    this.controls.ccdChosaItakusakiAndChosainInput().ShoriType().SimpleShokaiMode();
                    this.controls.ccdNinteiJohoInput().ShoriType().TokushuShuseiMode();
                    this.controls.ccdZenkaiNinteiKekka().ShokaiButtonType().ShokaiButtonNoneMode();
                    this.controls.ccdShinseiSonotaJohoInput().ShoriType().RirekiNinteiTorisage();
                    this.controls.btnChosaJokyo().disabled = false;
                    this.controls.btnCancel().disabled = false;
                    this.controls.btnKakutei().disabled = false;
                };
                DisplayType.prototype.tsuikaRirekiTsuika = function () {
                    this.controls.ccdKaigoNinteiShinseiKihonJohoInput().InputType().ShokaiMode();
                    this.controls.ccdNinteiShinseiTodokedesha().ShoriType().InputMode();
                    this.controls.ccdShujiiIryokikanAndShujiiInput().ShoriType().SimpleShokaiMode();
                    this.controls.ccdChosaItakusakiAndChosainInput().ShoriType().SimpleShokaiMode();
                    this.controls.ccdNinteiJohoInput().ShoriType().TokushuShuseiMode();
                    this.controls.ccdZenkaiNinteiKekka().ShokaiButtonType().ShokaiButtonNoneMode();
                    this.controls.ccdShinseiSonotaJohoInput().ShoriType().RirekTsuikaKyakka();
                    this.controls.btnChosaJokyo().disabled = false;
                    this.controls.btnCancel().disabled = false;
                    this.controls.btnKakutei().disabled = false;
                };
                DisplayType.prototype.kyakkaRirekiTsuika = function () {
                    this.controls.ccdKaigoNinteiShinseiKihonJohoInput().InputType().ShokaiMode();
                    this.controls.ccdNinteiShinseiTodokedesha().ShoriType().InputMode();
                    this.controls.ccdShujiiIryokikanAndShujiiInput().ShoriType().SimpleShokaiMode();
                    this.controls.ccdChosaItakusakiAndChosainInput().ShoriType().SimpleShokaiMode();
                    this.controls.ccdNinteiJohoInput().ShoriType().KyakkaRirekiTsuikaMode();
                    this.controls.ccdZenkaiNinteiKekka().ShokaiButtonType().ShokaiButtonNoneMode();
                    this.controls.ccdShinseiSonotaJohoInput().ShoriType().RirekTsuikaKyakka();
                    this.controls.btnChosaJokyo().disabled = false;
                    this.controls.btnCancel().disabled = false;
                    this.controls.btnKakutei().disabled = false;
                };
                DisplayType.prototype.shinseiTorikeshiRirekiTsuika = function () {
                    this.controls.ccdKaigoNinteiShinseiKihonJohoInput().InputType().ShokaiMode();
                    this.controls.ccdNinteiShinseiTodokedesha().ShoriType().InputMode();
                    this.controls.ccdShujiiIryokikanAndShujiiInput().ShoriType().SimpleShokaiMode();
                    this.controls.ccdChosaItakusakiAndChosainInput().ShoriType().SimpleShokaiMode();
                    this.controls.ccdNinteiJohoInput().ShoriType().ShinseiTorikeshiRirekiMode();
                    this.controls.ccdZenkaiNinteiKekka().ShokaiButtonType().ShokaiButtonNoneMode();
                    this.controls.ccdShinseiSonotaJohoInput().ShoriType().RirekiShinseiTorisage();
                    this.controls.btnChosaJokyo().disabled = false;
                    this.controls.btnCancel().disabled = false;
                    this.controls.btnKakutei().disabled = false;
                };
                DisplayType.prototype.ninteiShusei = function () {
                    this.controls.ccdKaigoNinteiShinseiKihonJohoInput().InputType().RirekiShuseiMode();
                    this.controls.ccdNinteiShinseiTodokedesha().ShoriType().InputMode();
                    this.controls.ccdShujiiIryokikanAndShujiiInput().ShoriType().SimpleShokaiMode();
                    this.controls.ccdChosaItakusakiAndChosainInput().ShoriType().SimpleShokaiMode();
                    this.controls.ccdNinteiJohoInput().ShoriType().TokushuShuseiMode();
                    this.controls.ccdZenkaiNinteiKekka().ShokaiButtonType().ShokaiButtonNoneMode();
                    this.controls.ccdShinseiSonotaJohoInput().ShoriType().TokushuRirekiShuseiMode();
                    this.controls.btnChosaJokyo().disabled = false;
                    this.controls.btnCancel().disabled = false;
                    this.controls.btnKakutei().disabled = false;
                };
                DisplayType.prototype.torikeshiRirekiShusei = function () {
                    this.controls.ccdKaigoNinteiShinseiKihonJohoInput().InputType().RirekiShuseiMode();
                    this.controls.ccdNinteiShinseiTodokedesha().ShoriType().InputMode();
                    this.controls.ccdShujiiIryokikanAndShujiiInput().ShoriType().SimpleShokaiMode();
                    this.controls.ccdChosaItakusakiAndChosainInput().ShoriType().SimpleShokaiMode();
                    this.controls.ccdNinteiJohoInput().ShoriType().KyakkaTorikeshiRirekiShusei();
                    this.controls.ccdZenkaiNinteiKekka().ShokaiButtonType().ShokaiButtonNoneMode();
                    this.controls.ccdShinseiSonotaJohoInput().ShoriType().RirekiShinseiTorisage();
                    this.controls.btnChosaJokyo().disabled = false;
                    this.controls.btnCancel().disabled = false;
                    this.controls.btnKakutei().disabled = false;
                };
                DisplayType.prototype.tsuikaRirekiShusei = function () {
                    this.controls.ccdKaigoNinteiShinseiKihonJohoInput().InputType().RirekiShuseiMode();
                    this.controls.ccdNinteiShinseiTodokedesha().ShoriType().InputMode();
                    this.controls.ccdShujiiIryokikanAndShujiiInput().ShoriType().SimpleShokaiMode();
                    this.controls.ccdChosaItakusakiAndChosainInput().ShoriType().SimpleShokaiMode();
                    this.controls.ccdNinteiJohoInput().ShoriType().TokushuShuseiMode();
                    this.controls.ccdZenkaiNinteiKekka().ShokaiButtonType().ShokaiButtonNoneMode();
                    this.controls.ccdShinseiSonotaJohoInput().ShoriType().RirekTsuikaKyakka();
                    this.controls.btnChosaJokyo().disabled = false;
                    this.controls.btnCancel().disabled = false;
                    this.controls.btnKakutei().disabled = false;
                };
                DisplayType.prototype.kyakkaRirekiShusei = function () {
                    this.controls.ccdKaigoNinteiShinseiKihonJohoInput().InputType().RirekiShuseiMode();
                    this.controls.ccdNinteiShinseiTodokedesha().ShoriType().InputMode();
                    this.controls.ccdShujiiIryokikanAndShujiiInput().ShoriType().SimpleShokaiMode();
                    this.controls.ccdChosaItakusakiAndChosainInput().ShoriType().SimpleShokaiMode();
                    this.controls.ccdNinteiJohoInput().ShoriType().KyakkaTorikeshiRirekiShusei();
                    this.controls.ccdZenkaiNinteiKekka().ShokaiButtonType().ShokaiButtonNoneMode();
                    this.controls.ccdShinseiSonotaJohoInput().ShoriType().RirekTsuikaKyakka();
                    this.controls.btnChosaJokyo().disabled = false;
                    this.controls.btnCancel().disabled = false;
                    this.controls.btnKakutei().disabled = false;
                };
                DisplayType.prototype.shinseiTorisageRirekiShusei = function () {
                    this.controls.ccdKaigoNinteiShinseiKihonJohoInput().InputType().RirekiShuseiMode();
                    this.controls.ccdNinteiShinseiTodokedesha().ShoriType().InputMode();
                    this.controls.ccdShujiiIryokikanAndShujiiInput().ShoriType().SimpleShokaiMode();
                    this.controls.ccdChosaItakusakiAndChosainInput().ShoriType().SimpleShokaiMode();
                    this.controls.ccdNinteiJohoInput().ShoriType().ShinseiTorikeshiRirekiMode();
                    this.controls.ccdZenkaiNinteiKekka().ShokaiButtonType().ShokaiButtonNoneMode();
                    this.controls.ccdShinseiSonotaJohoInput().ShoriType().RirekiShinseiTorisage();
                    this.controls.btnChosaJokyo().disabled = false;
                    this.controls.btnCancel().disabled = false;
                    this.controls.btnKakutei().disabled = false;
                };
                return DisplayType;
            })();
            Modes.DisplayType = DisplayType;
        })(RirekiShusei.Modes || (RirekiShusei.Modes = {}));
        var Modes = RirekiShusei.Modes;
    })(DBZ.RirekiShusei || (DBZ.RirekiShusei = {}));
    var RirekiShusei = DBZ.RirekiShusei;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (RirekiShusei) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new RirekiShusei.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        RirekiShusei.PublicProperties = PublicProperties;
    })(DBZ.RirekiShusei || (DBZ.RirekiShusei = {}));
    var RirekiShusei = DBZ.RirekiShusei;
})(DBZ || (DBZ = {}));
