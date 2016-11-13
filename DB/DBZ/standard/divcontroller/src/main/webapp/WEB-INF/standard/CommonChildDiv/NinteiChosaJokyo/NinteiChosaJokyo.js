var DBZ;
(function (DBZ) {
    (function (NinteiChosaJokyo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiChosaJokyo.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new NinteiChosaJokyo.PublicProperties(this.fieldName);
            };

            ModeController.prototype.DisplayType = function () {
                return new Modes.DisplayType(this.controls);
            };
            return ModeController;
        })();
        NinteiChosaJokyo.ModeController = ModeController;

        (function (Modes) {
            var DisplayType = (function () {
                function DisplayType(controls) {
                    this.controls = controls;
                }
                DisplayType.prototype.input = function () {
                    this.controls.NinteiChosa().readOnly = false;
                    this.controls.txtNinteiChosainCode().readOnly = false;
                    this.controls.btnChosainGuide().disabled = false;
                    this.controls.txtNinteiChosainName().readOnly = true;
                    this.controls.txtNinteiChosaItakusakiCode().readOnly = false;
                    this.controls.btnItakusakiGuide().disabled = false;
                    this.controls.txtNinteiChosaItakusakiName().readOnly = true;
                    this.controls.btnChosainJohoClear().disabled = true;
                    this.controls.txtNinteiChosaYubinNo().readOnly = true;
                    this.controls.txtNinteiChosaJusho().readOnly = true;
                    this.controls.txtNinteiChosaTelNo().readOnly = true;
                    this.controls.txtNinteiChosaIraiDate().readOnly = false;
                    this.controls.txtNinteiChosaJisshiYoteiDate().readOnly = false;
                    this.controls.txtNinteiChosaJisshiDate().readOnly = false;
                    this.controls.ddlNinteiChosaItakusakiKubun().readOnly = false;
                    this.controls.HomonChosasaki().readOnly = false;
                    this.controls.txtChosasakiName().readOnly = true;
                    this.controls.btnZenKaiFukusha().disabled = false;
                    this.controls.btnHonninJushoFukusha().disabled = false;
                    this.controls.btnNyushoShisetsuFukusha().disabled = false;
                    this.controls.btnHomonChosaClear().disabled = false;
                    this.controls.txtChosasakiYubinNo().readOnly = false;
                    this.controls.txtChosasakiJusho().readOnly = false;
                    this.controls.txtChosasakiTelNo().readOnly = false;
                    this.controls.ShujiiAndShujiIryoKikan().readOnly = false;
                    this.controls.txtShujiiCode().readOnly = false;
                    this.controls.btnShujiiGuide().disabled = false;
                    this.controls.txtShujiiName().readOnly = true;
                    this.controls.txtShujiiIryoKikanCode().readOnly = false;
                    this.controls.btnIryoKikanGuide().disabled = false;
                    this.controls.txtShujiiIryoKikanName().readOnly = true;
                    this.controls.btnShujiiJohoClear().disabled = false;
                    this.controls.txtShujiiIryoKikanYubinNo().readOnly = true;
                    this.controls.txtShujiiIryoKikanJusho().readOnly = true;
                    this.controls.txtShujiiIryoKikanTelNo().readOnly = true;
                    this.controls.txtShujiiIryoKikanIraiDate().readOnly = false;
                    this.controls.txtShujiiIryoKikanNyushuYoteiDate().readOnly = false;
                    this.controls.txtShujiiIryoKikanNyushuDate().readOnly = false;
                    this.controls.chkShujiiKubun().readOnly = false;
                    this.controls.IchijiHantei().readOnly = false;
                    this.controls.ddlYokaigodo().readOnly = false;
                    this.controls.txtIchijiHanteiDate().readOnly = false;
                    this.controls.ddlNinchishoKasangoYokaigodo().readOnly = false;
                    this.controls.KaigoNinteiShinsakai().readOnly = false;
                    this.controls.txtShinsakaiShiryoSakuseiDate().readOnly = false;
                    this.controls.txtShinsakaiKaisaiYoteiDate().readOnly = false;
                    this.controls.txtNijiHanteiDate().readOnly = false;
                    this.controls.ddlNijiHanteiKekka().readOnly = false;
                    this.controls.txtNijiHanteiYukoKikan().readOnly = false;
                    this.controls.txtNinteiYukoKikanFrom().readOnly = false;
                    this.controls.txtNinteiYukoKikanTo().readOnly = false;
                    this.controls.EnkiTsuchi().readOnly = false;
                    this.controls.txtEnkiTsuchiHakkoDay().readOnly = false;
                    this.controls.txtEnkiTsuchiHakkoCount().readOnly = false;
                    this.controls.btnAllClear().disabled = false;
                    this.controls.btnTorikeshi().disabled = false;
                    this.controls.btnKakutei().disabled = false;
                };

                DisplayType.prototype.shokai = function () {
                    this.controls.NinteiChosa().readOnly = true;
                    this.controls.txtNinteiChosainCode().readOnly = true;
                    this.controls.btnChosainGuide().disabled = true;
                    this.controls.txtNinteiChosainName().readOnly = true;
                    this.controls.txtNinteiChosaItakusakiCode().readOnly = true;
                    this.controls.btnItakusakiGuide().disabled = true;
                    this.controls.txtNinteiChosaItakusakiName().readOnly = true;
                    this.controls.btnChosainJohoClear().disabled = true;
                    this.controls.txtNinteiChosaYubinNo().readOnly = true;
                    this.controls.txtNinteiChosaJusho().readOnly = true;
                    this.controls.txtNinteiChosaTelNo().readOnly = true;
                    this.controls.txtNinteiChosaIraiDate().readOnly = true;
                    this.controls.txtNinteiChosaJisshiYoteiDate().readOnly = true;
                    this.controls.txtNinteiChosaJisshiDate().readOnly = true;
                    this.controls.ddlNinteiChosaItakusakiKubun().readOnly = true;
                    this.controls.HomonChosasaki().readOnly = true;
                    this.controls.txtChosasakiName().readOnly = true;
                    this.controls.btnZenKaiFukusha().disabled = true;
                    this.controls.btnHonninJushoFukusha().disabled = true;
                    this.controls.btnNyushoShisetsuFukusha().disabled = true;
                    this.controls.btnHomonChosaClear().disabled = true;
                    this.controls.txtChosasakiYubinNo().readOnly = true;
                    this.controls.txtChosasakiJusho().readOnly = true;
                    this.controls.txtChosasakiTelNo().readOnly = true;
                    this.controls.ShujiiAndShujiIryoKikan().readOnly = true;
                    this.controls.txtShujiiCode().readOnly = true;
                    this.controls.btnShujiiGuide().disabled = true;
                    this.controls.txtShujiiName().readOnly = true;
                    this.controls.txtShujiiIryoKikanCode().readOnly = true;
                    this.controls.btnIryoKikanGuide().disabled = true;
                    this.controls.txtShujiiIryoKikanName().readOnly = true;
                    this.controls.btnShujiiJohoClear().disabled = true;
                    this.controls.txtShujiiIryoKikanYubinNo().readOnly = true;
                    this.controls.txtShujiiIryoKikanJusho().readOnly = true;
                    this.controls.txtShujiiIryoKikanTelNo().readOnly = true;
                    this.controls.txtShujiiIryoKikanIraiDate().readOnly = true;
                    this.controls.txtShujiiIryoKikanNyushuYoteiDate().readOnly = true;
                    this.controls.txtShujiiIryoKikanNyushuDate().readOnly = true;
                    this.controls.chkShujiiKubun().readOnly = true;
                    this.controls.IchijiHantei().readOnly = true;
                    this.controls.ddlYokaigodo().readOnly = true;
                    this.controls.txtIchijiHanteiDate().readOnly = true;
                    this.controls.ddlNinchishoKasangoYokaigodo().readOnly = true;
                    this.controls.KaigoNinteiShinsakai().readOnly = true;
                    this.controls.txtShinsakaiShiryoSakuseiDate().readOnly = true;
                    this.controls.txtShinsakaiKaisaiYoteiDate().readOnly = true;
                    this.controls.txtNijiHanteiDate().readOnly = true;
                    this.controls.ddlNijiHanteiKekka().readOnly = true;
                    this.controls.txtNijiHanteiYukoKikan().readOnly = true;
                    this.controls.txtNinteiYukoKikanFrom().readOnly = true;
                    this.controls.txtNinteiYukoKikanTo().readOnly = true;
                    this.controls.EnkiTsuchi().readOnly = true;
                    this.controls.txtEnkiTsuchiHakkoDay().readOnly = true;
                    this.controls.txtEnkiTsuchiHakkoCount().readOnly = true;
                    this.controls.btnAllClear().disabled = true;
                    this.controls.btnTorikeshi().disabled = true;
                    this.controls.btnKakutei().disabled = true;
                };
                return DisplayType;
            })();
            Modes.DisplayType = DisplayType;
        })(NinteiChosaJokyo.Modes || (NinteiChosaJokyo.Modes = {}));
        var Modes = NinteiChosaJokyo.Modes;
    })(DBZ.NinteiChosaJokyo || (DBZ.NinteiChosaJokyo = {}));
    var NinteiChosaJokyo = DBZ.NinteiChosaJokyo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (NinteiChosaJokyo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiChosaJokyo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        NinteiChosaJokyo.PublicProperties = PublicProperties;
    })(DBZ.NinteiChosaJokyo || (DBZ.NinteiChosaJokyo = {}));
    var NinteiChosaJokyo = DBZ.NinteiChosaJokyo;
})(DBZ || (DBZ = {}));
