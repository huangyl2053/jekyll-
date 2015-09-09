var DBZ;
(function (DBZ) {
    (function (NinteiChosaJokyo) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        NinteiChosaJokyo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "NinteiChosaJokyo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.NinteiChosaJokyo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.NinteiChosaJokyo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.NinteiChosaJokyo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.NinteiChosa = function () {
                return new UZA.Panel(this.convFiledName("NinteiChosa"));
            };

            Controls.prototype.txtNinteiChosainCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtNinteiChosainCode"));
            };

            Controls.prototype.btnChosainGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnChosainGuide"));
            };

            Controls.prototype.txtNinteiChosainName = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiChosainName"));
            };

            Controls.prototype.txtNinteiChosaItakusakiCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtNinteiChosaItakusakiCode"));
            };

            Controls.prototype.btnItakusakiGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnItakusakiGuide"));
            };

            Controls.prototype.txtNinteiChosaItakusakiName = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiChosaItakusakiName"));
            };

            Controls.prototype.txtNinteiChosaYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtNinteiChosaYubinNo"));
            };

            Controls.prototype.txtNinteiChosaJusho = function () {
                return new UZA.TextBoxJusho(this.convFiledName("txtNinteiChosaJusho"));
            };

            Controls.prototype.txtNinteiChosaTelNo = function () {
                return new UZA.TextBoxTelNo(this.convFiledName("txtNinteiChosaTelNo"));
            };

            Controls.prototype.txtNinteiChosaIraiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiChosaIraiDate"));
            };

            Controls.prototype.txtNinteiChosaJisshiYoteiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiChosaJisshiYoteiDate"));
            };

            Controls.prototype.txtNinteiChosaJisshiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiChosaJisshiDate"));
            };

            Controls.prototype.ddlNinteiChosaItakusakiKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlNinteiChosaItakusakiKubun"));
            };

            Controls.prototype.HomonChosasaki = function () {
                return new UZA.Panel(this.convFiledName("HomonChosasaki"));
            };

            Controls.prototype.txtChosasakiName = function () {
                return new UZA.TextBox(this.convFiledName("txtChosasakiName"));
            };

            Controls.prototype.txtChosasakiYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtChosasakiYubinNo"));
            };

            Controls.prototype.txtChosasakiJusho = function () {
                return new UZA.TextBoxJusho(this.convFiledName("txtChosasakiJusho"));
            };

            Controls.prototype.txtChosasakiTelNo = function () {
                return new UZA.TextBoxTelNo(this.convFiledName("txtChosasakiTelNo"));
            };

            Controls.prototype.ShujiiAndShujiIryoKikan = function () {
                return new UZA.Panel(this.convFiledName("ShujiiAndShujiIryoKikan"));
            };

            Controls.prototype.txtShujiiCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShujiiCode"));
            };

            Controls.prototype.btnShujiiGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnShujiiGuide"));
            };

            Controls.prototype.txtShujiiName = function () {
                return new UZA.TextBox(this.convFiledName("txtShujiiName"));
            };

            Controls.prototype.txtShujiiIryoKikanCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShujiiIryoKikanCode"));
            };

            Controls.prototype.btnIryoKikanGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnIryoKikanGuide"));
            };

            Controls.prototype.txtShujiiIryoKikanName = function () {
                return new UZA.TextBox(this.convFiledName("txtShujiiIryoKikanName"));
            };

            Controls.prototype.txtShujiiIryoKikanYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtShujiiIryoKikanYubinNo"));
            };

            Controls.prototype.txtShujiiIryoKikanJusho = function () {
                return new UZA.TextBoxJusho(this.convFiledName("txtShujiiIryoKikanJusho"));
            };

            Controls.prototype.txtShujiiIryoKikanTelNo = function () {
                return new UZA.TextBoxTelNo(this.convFiledName("txtShujiiIryoKikanTelNo"));
            };

            Controls.prototype.txtShujiiIryoKikanIraiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShujiiIryoKikanIraiDate"));
            };

            Controls.prototype.txtShujiiIryoKikanNyushuYoteiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShujiiIryoKikanNyushuYoteiDate"));
            };

            Controls.prototype.txtShujiiIryoKikanNyushuDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShujiiIryoKikanNyushuDate"));
            };

            Controls.prototype.chkShujiiKubun = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkShujiiKubun"));
            };

            Controls.prototype.IchijiHantei = function () {
                return new UZA.Panel(this.convFiledName("IchijiHantei"));
            };

            Controls.prototype.ddlYokaigodo = function () {
                return new UZA.DropDownList(this.convFiledName("ddlYokaigodo"));
            };

            Controls.prototype.txtIchijiHanteiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchijiHanteiDate"));
            };

            Controls.prototype.ddlNinchishoKasangoYokaigodo = function () {
                return new UZA.DropDownList(this.convFiledName("ddlNinchishoKasangoYokaigodo"));
            };

            Controls.prototype.KaigoNinteiShinsakai = function () {
                return new UZA.Panel(this.convFiledName("KaigoNinteiShinsakai"));
            };

            Controls.prototype.txtShinsakaiShiryoSakuseiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinsakaiShiryoSakuseiDate"));
            };

            Controls.prototype.txtShinsakaiKaisaiYoteiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinsakaiKaisaiYoteiDate"));
            };

            Controls.prototype.txtNijiHanteiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNijiHanteiDate"));
            };

            Controls.prototype.ddlNijiHanteiKekka = function () {
                return new UZA.DropDownList(this.convFiledName("ddlNijiHanteiKekka"));
            };

            Controls.prototype.txtNijiHanteiYukoKikan = function () {
                return new UZA.TextBox(this.convFiledName("txtNijiHanteiYukoKikan"));
            };

            Controls.prototype.txtNinteiYukoKikanFrom = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiYukoKikanFrom"));
            };

            Controls.prototype.txtNinteiYukoKikanTo = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiYukoKikanTo"));
            };

            Controls.prototype.EnkiTsuchi = function () {
                return new UZA.Panel(this.convFiledName("EnkiTsuchi"));
            };

            Controls.prototype.txtEnkiTsuchiHakkoDay = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtEnkiTsuchiHakkoDay"));
            };

            Controls.prototype.txtEnkiTsuchiHakkoCount = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtEnkiTsuchiHakkoCount"));
            };

            Controls.prototype.btnKakutei = function () {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            };

            Controls.prototype.btnTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnTorikeshi"));
            };
            return Controls;
        })();
        NinteiChosaJokyo.Controls = Controls;
    })(DBZ.NinteiChosaJokyo || (DBZ.NinteiChosaJokyo = {}));
    var NinteiChosaJokyo = DBZ.NinteiChosaJokyo;
})(DBZ || (DBZ = {}));
