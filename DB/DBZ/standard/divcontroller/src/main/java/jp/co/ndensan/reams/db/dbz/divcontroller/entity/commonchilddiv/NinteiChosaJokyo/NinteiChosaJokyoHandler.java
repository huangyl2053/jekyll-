/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaJokyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosajokyo.NinteiChosaJokyoDataPass;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaItakuKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 共有子Div「認定調査状況」のhandlerクラスです
 *
 * @reamsid_L DBZ-1330-020 chengsanyuan
 */
public class NinteiChosaJokyoHandler {

    private final NinteiChosaJokyoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 認定調査状況Div
     */
    public NinteiChosaJokyoHandler(NinteiChosaJokyoDiv div) {
        this.div = div;
    }

    /**
     * Divを初期化する
     */
    public void setLoad() {
        NinteiChosaJokyoDataPass konkaiDataPass = DataPassingConverter.deserialize(div.getHdnSerializedBusiness_Konkai(),
                NinteiChosaJokyoDataPass.class);
//        RString displayModeKey = div.getHdnDisplayModeKey();
//        if (new RString("1").equals(displayModeKey)) {
//            div.setMode_DisplayType(NinteiChosaJokyoDiv.DisplayType.shokai);
//        }
//        if (new RString("2").equals(displayModeKey)) {
//            div.setMode_DisplayType(NinteiChosaJokyoDiv.DisplayType.input);
//        }
        List<KeyValueDataSource> keyValueList = new ArrayList<>();
        for (ChosaItakuKubunCode chosaItaku : ChosaItakuKubunCode.values()) {
            keyValueList.add(new KeyValueDataSource(chosaItaku.getコード(), chosaItaku.get名称()));
        }
        div.getDdlNinteiChosaItakusakiKubun().setDataSource(keyValueList);
        if (konkaiDataPass != null) {
            List<KeyValueDataSource> yokaigodoList = new ArrayList<>();
            if (konkaiDataPass.get厚労省IF識別コード() != null && !konkaiDataPass.get厚労省IF識別コード().isEmpty()) {
                switch (KoroshoIfShikibetsuCode.toValue(konkaiDataPass.get厚労省IF識別コード().value())) {
                    case 認定ｿﾌﾄ2009:
                    case 認定ｿﾌﾄ2009_SP3:
                        for (YokaigoJotaiKubun09 yokaigoJotaiKubun09 : YokaigoJotaiKubun09.values()) {
                            yokaigodoList.add(new KeyValueDataSource(yokaigoJotaiKubun09.getコード(),
                                    yokaigoJotaiKubun09.get名称()));
                        }
                        break;
                    case 認定ｿﾌﾄ2002:
                        for (YokaigoJotaiKubun02 yokaigoJotaiKubun02 : YokaigoJotaiKubun02.values()) {
                            yokaigodoList.add(new KeyValueDataSource(yokaigoJotaiKubun02.getコード(),
                                    yokaigoJotaiKubun02.get名称()));
                        }
                        break;
                    case 認定ｿﾌﾄ2006_新要介護認定適用区分が未適用:
                        for (YokaigoJotaiKubun06 yokaigoJotaiKubun06 : YokaigoJotaiKubun06.values()) {
                            yokaigodoList.add(new KeyValueDataSource(yokaigoJotaiKubun06.getコード(),
                                    yokaigoJotaiKubun06.get名称()));
                        }
                        break;
                    case 認定ｿﾌﾄ99:
                        for (YokaigoJotaiKubun99 yokaigoJotaiKubun99 : YokaigoJotaiKubun99.values()) {
                            yokaigodoList.add(new KeyValueDataSource(yokaigoJotaiKubun99.getコード(),
                                    yokaigoJotaiKubun99.get名称()));
                        }
                        break;
                    default:
                }
            }
            div.getDdlYokaigodo().setDataSource(yokaigodoList);
            div.getDdlNinchishoKasangoYokaigodo().setDataSource(yokaigodoList);
            div.getDdlNijiHanteiKekka().setDataSource(yokaigodoList);
            set画面項目(konkaiDataPass);
            div.setHdnInput(get画面項目());
        }
    }

    /**
     * 認定調査Div上の入力内容をクリアする。
     */
    public void クリア認定調査() {
        div.getTxtNinteiChosainCode().clearValue();
        div.getTxtNinteiChosainName().clearValue();
        div.getTxtNinteiChosaItakusakiCode().clearValue();
        div.getTxtNinteiChosaItakusakiName().clearValue();
        div.getTxtNinteiChosaYubinNo().clearValue();
        div.getTxtNinteiChosaJusho().clearDomain();
        div.getTxtNinteiChosaTelNo().clearDomain();
        div.getTxtNinteiChosaIraiDate().clearValue();
        div.getTxtNinteiChosaJisshiYoteiDate().clearValue();
        div.getTxtNinteiChosaJisshiDate().clearValue();
        div.getDdlNinteiChosaItakusakiKubun().setSelectedIndex(0);
    }

    /**
     * 訪問調査Div上の入力内容をクリアする。
     */
    public void クリア訪問調査() {
        div.getTxtChosasakiName().clearValue();
        div.getTxtChosasakiYubinNo().clearValue();
        div.getTxtChosasakiJusho().clearDomain();
        div.getTxtChosasakiTelNo().clearDomain();
    }

    /**
     * 主治医Div上の入力内容をクリアする。
     */
    public void クリア主治医() {
        div.getTxtShujiiCode().clearValue();
        div.getTxtShujiiName().clearValue();
        div.getTxtShujiiIryoKikanCode().clearValue();
        div.getTxtShujiiIryoKikanName().clearValue();
        div.getTxtShujiiIryoKikanYubinNo().clearValue();
        div.getTxtShujiiIryoKikanJusho().clearDomain();
        div.getTxtShujiiIryoKikanTelNo().clearDomain();
        div.getTxtShujiiIryoKikanIraiDate().clearValue();
        div.getTxtShujiiIryoKikanNyushuYoteiDate().clearValue();
        div.getTxtShujiiIryoKikanNyushuDate().clearValue();
        div.getChkShujiiKubun().setSelectedItemsByKey(new ArrayList<RString>());
    }

    /**
     * 認定調査状況Divの入力内容をクリアする。
     */
    public void clearAll() {
        this.クリア認定調査();
        this.クリア訪問調査();
        this.クリア主治医();
        if (!div.getDdlYokaigodo().getDataSource().isEmpty() && div.getDdlYokaigodo().getDataSource() != null) {
            div.getDdlYokaigodo().setSelectedIndex(0);
        }
        div.getTxtIchijiHanteiDate().clearValue();
        if (!div.getDdlNinchishoKasangoYokaigodo().getDataSource().isEmpty() && div.getDdlNinchishoKasangoYokaigodo().getDataSource() != null) {
            div.getDdlNinchishoKasangoYokaigodo().setSelectedIndex(0);
        }
        div.getTxtShinsakaiShiryoSakuseiDate().clearValue();
        div.getTxtShinsakaiKaisaiYoteiDate().clearValue();
        div.getTxtNijiHanteiDate().clearValue();
        if (!div.getDdlNijiHanteiKekka().getDataSource().isEmpty() && div.getDdlNijiHanteiKekka().getDataSource() != null) {
            div.getDdlNijiHanteiKekka().setSelectedIndex(0);
        }
        div.getTxtNijiHanteiYukoKikan().clearValue();
        div.getTxtNinteiYukoKikanFrom().clearValue();
        div.getTxtNinteiYukoKikanTo().clearValue();
        div.getTxtEnkiTsuchiHakkoDay().clearValue();
        div.getTxtEnkiTsuchiHakkoCount().clearValue();
    }

    /**
     * 画面の項目値をhiddenInputに設定します。
     *
     * @return 画面の項目値
     */
    @SuppressWarnings({"empty-statement", "empty-statement"})
    public RString get画面項目() {
        RStringBuilder rsb = new RStringBuilder();
        rsb.append(div.getTxtNinteiChosainCode().getText() != null ? div.getTxtNinteiChosainCode().getValue() : RString.EMPTY);
        rsb.append(div.getTxtNinteiChosainName().getValue() != null ? div.getTxtNinteiChosainName().getValue() : RString.EMPTY);
        rsb.append(div.getTxtNinteiChosaItakusakiCode().getText() != null ? div.getTxtNinteiChosaItakusakiCode().getValue() : RString.EMPTY);
        rsb.append(div.getTxtNinteiChosaItakusakiName().getValue() != null ? div.getTxtNinteiChosaItakusakiName().getValue() : RString.EMPTY);
        rsb.append(div.getTxtNinteiChosaYubinNo().getValue() != null ? div.getTxtNinteiChosaYubinNo().getValue() : RString.EMPTY);
        rsb.append(div.getTxtNinteiChosaJusho().getDomain() != null ? div.getTxtNinteiChosaJusho().getDomain().value() : RString.EMPTY);
        try {
            rsb.append(div.getTxtNinteiChosaTelNo().getDomain() != null ? div.getTxtNinteiChosaTelNo().getDomain().value() : RString.EMPTY);
        } catch (NullPointerException ex) {
            rsb.append(RString.EMPTY);
        };
        rsb.append(div.getTxtNinteiChosaIraiDate().getValue() != null ? div.getTxtNinteiChosaIraiDate().getValue() : RString.EMPTY);
        rsb.append(div.getTxtNinteiChosaJisshiYoteiDate().getValue() != null ? div.getTxtNinteiChosaJisshiYoteiDate().getValue() : RString.EMPTY);
        rsb.append(div.getTxtNinteiChosaJisshiDate().getValue() != null ? div.getTxtNinteiChosaJisshiDate().getValue() : RString.EMPTY);
        rsb.append(div.getDdlNinteiChosaItakusakiKubun().getSelectedKey());
        rsb.append(div.getTxtChosasakiName().getValue() != null ? div.getTxtChosasakiName().getValue() : RString.EMPTY);
        rsb.append(div.getTxtChosasakiYubinNo().getValue() != null ? div.getTxtChosasakiYubinNo().getValue() : RString.EMPTY);
        try {
            rsb.append(div.getTxtChosasakiJusho().getDomain() != null ? div.getTxtChosasakiJusho().getDomain().value() : RString.EMPTY);
        } catch (NullPointerException ex) {
            rsb.append(RString.EMPTY);
        };
        try {
            rsb.append(div.getTxtChosasakiTelNo().getDomain() != null ? div.getTxtChosasakiTelNo().getDomain().value() : RString.EMPTY);
        } catch (NullPointerException ex) {
            rsb.append(RString.EMPTY);
        };
        rsb.append(div.getTxtShujiiCode().getText() != null ? div.getTxtShujiiCode().getValue() : RString.EMPTY);
        rsb.append(div.getTxtShujiiName().getValue() != null ? div.getTxtShujiiName().getValue() : RString.EMPTY);
        rsb.append(div.getTxtShujiiIryoKikanCode().getText() != null ? div.getTxtShujiiIryoKikanCode().getValue() : RString.EMPTY);
        rsb.append(div.getTxtShujiiIryoKikanName().getValue() != null ? div.getTxtShujiiIryoKikanName().getValue() : RString.EMPTY);
        rsb.append(div.getTxtShujiiIryoKikanYubinNo().getValue() != null ? div.getTxtShujiiIryoKikanYubinNo().getValue() : RString.EMPTY);
        rsb.append(div.getTxtShujiiIryoKikanJusho().getDomain() != null ? div.getTxtShujiiIryoKikanJusho().getDomain().value() : RString.EMPTY);
        try {
            rsb.append(div.getTxtShujiiIryoKikanTelNo().getDomain() != null ? div.getTxtShujiiIryoKikanTelNo().getDomain().value() : RString.EMPTY);
        } catch (NullPointerException ex) {
            rsb.append(RString.EMPTY);
        };
        rsb.append(div.getTxtShujiiIryoKikanIraiDate().getValue() != null ? div.getTxtShujiiIryoKikanIraiDate().getValue() : RString.EMPTY);
        rsb.append(div.getTxtShujiiIryoKikanNyushuYoteiDate().getValue() != null ? div.getTxtShujiiIryoKikanNyushuYoteiDate().getValue() : RString.EMPTY);
        rsb.append(div.getTxtShujiiIryoKikanNyushuDate().getValue() != null ? div.getTxtShujiiIryoKikanNyushuDate().getValue() : RString.EMPTY);
        if (!div.getChkShujiiKubun().getSelectedKeys().isEmpty()) {
            rsb.append(div.getChkShujiiKubun().getSelectedKeys().get(0));
        } else {
            rsb.append(RString.EMPTY);
        }
        rsb.append(div.getDdlYokaigodo().getSelectedKey());
        rsb.append(div.getTxtIchijiHanteiDate().getValue() != null ? div.getTxtIchijiHanteiDate().getValue() : RString.EMPTY);
        rsb.append(div.getDdlNinchishoKasangoYokaigodo().getSelectedKey());
        rsb.append(div.getTxtShinsakaiShiryoSakuseiDate().getValue() != null ? div.getTxtShinsakaiShiryoSakuseiDate().getValue() : RString.EMPTY);
        rsb.append(div.getTxtShinsakaiKaisaiYoteiDate().getValue() != null ? div.getTxtShinsakaiKaisaiYoteiDate().getValue() : RString.EMPTY);
        rsb.append(div.getTxtNijiHanteiDate().getValue() != null ? div.getTxtNijiHanteiDate().getValue() : RString.EMPTY);
        rsb.append(div.getDdlNijiHanteiKekka().getSelectedKey());
        rsb.append(div.getTxtNijiHanteiYukoKikan().getValue() != null ? div.getTxtNijiHanteiYukoKikan().getValue() : RString.EMPTY);
        rsb.append(div.getTxtNinteiYukoKikanFrom().getValue() != null ? div.getTxtNinteiYukoKikanFrom().getValue() : RString.EMPTY);
        rsb.append(div.getTxtNinteiYukoKikanTo().getValue() != null ? div.getTxtNinteiYukoKikanTo().getValue() : RString.EMPTY);
        rsb.append(div.getTxtEnkiTsuchiHakkoDay().getValue() != null ? div.getTxtEnkiTsuchiHakkoDay().getValue() : RString.EMPTY);
        if (div.getTxtEnkiTsuchiHakkoCount().getValue() != null) {
            rsb.append(div.getTxtEnkiTsuchiHakkoCount().getValue());
        }
        return rsb.toRString();
    }

    /**
     * 画面にセットされているデータをDataPassing用クラスにセットする。
     */
    public void set画面項目データパッシング() {
        NinteiChosaJokyoDataPass konkaiDataPass = new NinteiChosaJokyoDataPass();
        konkaiDataPass.set認定調査員コード(div.getTxtNinteiChosainCode().getValue());
        konkaiDataPass.set調査員氏名(div.getTxtNinteiChosainName().getValue());
        konkaiDataPass.set認定調査委託先コード(div.getTxtNinteiChosaItakusakiCode().getValue());
        konkaiDataPass.set事業者名称(div.getTxtNinteiChosaItakusakiName().getValue());
        konkaiDataPass.set認定郵便番号(div.getTxtNinteiChosaYubinNo().getValue());
        konkaiDataPass.set認定住所(div.getTxtNinteiChosaJusho().getDomain().value());
        konkaiDataPass.set認定電話番号(div.getTxtNinteiChosaTelNo().getDomain());
        konkaiDataPass.set認定調査依頼年月日(div.getTxtNinteiChosaIraiDate().getValue());
        konkaiDataPass.set認定調査予定年月日(div.getTxtNinteiChosaJisshiYoteiDate().getValue());
        konkaiDataPass.set認定調査実施年月日(div.getTxtNinteiChosaJisshiDate().getValue());
        konkaiDataPass.set調査委託区分(div.getDdlNinteiChosaItakusakiKubun().getSelectedKey());
        konkaiDataPass.set訪問調査先名称(new AtenaMeisho(div.getTxtChosasakiName().getValue()));
        konkaiDataPass.set訪問調査先郵便番号(div.getTxtChosasakiYubinNo().getValue());
        konkaiDataPass.set訪問調査先住所(div.getTxtChosasakiJusho().getDomain());
        konkaiDataPass.set訪問調査先電話番号(div.getTxtChosasakiTelNo().getDomain());
        konkaiDataPass.set主治医コード(div.getTxtShujiiCode().getValue());
        konkaiDataPass.set主治医氏名(div.getTxtShujiiName().getValue());
        konkaiDataPass.set主治医医療機関コード(div.getTxtShujiiIryoKikanCode().getValue());
        konkaiDataPass.set医療機関名称(div.getTxtShujiiIryoKikanName().getValue());
        konkaiDataPass.set主治医郵便番号(div.getTxtShujiiIryoKikanYubinNo().getValue());
        konkaiDataPass.set主治医住所(div.getTxtShujiiIryoKikanJusho().getDomain().value());
        konkaiDataPass.set主治医電話番号(div.getTxtShujiiIryoKikanTelNo().getDomain());
        konkaiDataPass.set主治医意見書作成依頼年月日(div.getTxtShujiiIryoKikanIraiDate().getValue());
        konkaiDataPass.set主治医意見書登録予定年月日(div.getTxtShujiiIryoKikanNyushuYoteiDate().getValue());
        konkaiDataPass.set主治医意見書記入年月日(div.getTxtShujiiIryoKikanNyushuDate().getValue());
        konkaiDataPass.set指定医フラグ(div.getChkShujiiKubun().isAllSelected());
        konkaiDataPass.set要介護認定一次判定結果コード(new Code(div.getDdlYokaigodo().getSelectedKey()));
        konkaiDataPass.set要介護認定一次判定年月日(div.getTxtIchijiHanteiDate().getValue());
        konkaiDataPass.set要介護認定一次判定結果コード_認知症加算(new Code(div.getDdlNinchishoKasangoYokaigodo().getSelectedKey()));
        konkaiDataPass.set介護認定審査会資料作成年月日(div.getTxtShinsakaiShiryoSakuseiDate().getValue());
        konkaiDataPass.set認定審査会予定年月日(div.getTxtShinsakaiKaisaiYoteiDate().getValue());
        konkaiDataPass.set二次判定年月日(div.getTxtNijiHanteiDate().getValue());
        konkaiDataPass.set二次判定要介護状態区分コード(new Code(div.getDdlNijiHanteiKekka().getSelectedKey()));
        if (div.getTxtNijiHanteiYukoKikan().getValue().isEmpty()) {
            konkaiDataPass.set二次判定認定有効期間(0);
        } else {
            konkaiDataPass.set二次判定認定有効期間(Integer.parseInt(div.getTxtNijiHanteiYukoKikan().getValue().toString()));
        }
        konkaiDataPass.set二次判定認定有効開始年月日(div.getTxtNinteiYukoKikanFrom().getValue());
        konkaiDataPass.set二次判定認定有効終了年月日(div.getTxtNinteiYukoKikanTo().getValue());
        konkaiDataPass.set延期通知発行年月日(div.getTxtEnkiTsuchiHakkoDay().getValue());
        if (div.getTxtEnkiTsuchiHakkoCount().getValue() != null) {
            konkaiDataPass.set延期通知発行回数(div.getTxtEnkiTsuchiHakkoCount().getValue().intValue());
        }
        NinteiChosaJokyoDataPass dataPass = DataPassingConverter.deserialize(div.getHdnSerializedBusiness_Konkai(),
                NinteiChosaJokyoDataPass.class);
        if (dataPass != null) {
            konkaiDataPass.set市町村コード(dataPass.get市町村コード());
            konkaiDataPass.set厚労省IF識別コード(dataPass.get厚労省IF識別コード());
            konkaiDataPass.set申請書管理番号(dataPass.get申請書管理番号());
        }

        div.setHdnSerializedBusiness_Konkai(DataPassingConverter.serialize(konkaiDataPass));
    }

    /**
     * 訪問調査情報を本人の住所からセットする
     */
    public void set画面項目By本人情報() {
        NinteiChosaJokyoDataPass konkaiDataPass = DataPassingConverter.deserialize(div.getHdnSerializedBusiness_Konkai(),
                NinteiChosaJokyoDataPass.class);
        if (konkaiDataPass != null) {
            div.getTxtChosasakiName().setValue(konkaiDataPass.get訪問調査先名称().value());
            div.getTxtChosasakiYubinNo().setValue(konkaiDataPass.get訪問調査先郵便番号());
            div.getTxtChosasakiJusho().setDomain(konkaiDataPass.get訪問調査先住所());
            div.getTxtChosasakiTelNo().setDomain(konkaiDataPass.get訪問調査先電話番号());
        }
    }

    /**
     * 前回情報から訪問調査情報を複写する。
     */
    public void set画面項目By前回情報() {
        NinteiChosaJokyoDataPass zenkaiDataPass = DataPassingConverter.deserialize(div.getHdnSerializedBusiness_Zenkai(),
                NinteiChosaJokyoDataPass.class);
        if (zenkaiDataPass != null) {
            div.getTxtChosasakiName().setValue(zenkaiDataPass.get訪問調査先名称().value());
            div.getTxtChosasakiYubinNo().setValue(zenkaiDataPass.get訪問調査先郵便番号());
            div.getTxtChosasakiJusho().setDomain(zenkaiDataPass.get訪問調査先住所());
            div.getTxtChosasakiTelNo().setDomain(zenkaiDataPass.get訪問調査先電話番号());
        }
    }

    private void set画面項目(NinteiChosaJokyoDataPass konkaiDataPass) {
        div.getTxtNinteiChosainCode().setValue(konkaiDataPass.get認定調査員コード());
        div.getTxtNinteiChosainName().setValue(konkaiDataPass.get調査員氏名());
        div.getTxtNinteiChosaItakusakiCode().setValue(konkaiDataPass.get認定調査委託先コード());
        div.getTxtNinteiChosaItakusakiName().setValue(konkaiDataPass.get事業者名称());
        div.getTxtNinteiChosaYubinNo().setValue(konkaiDataPass.get認定郵便番号());
        if (konkaiDataPass.get認定住所() != null && !konkaiDataPass.get認定住所().isEmpty()) {
            div.getTxtNinteiChosaJusho().setDomain(new AtenaJusho(konkaiDataPass.get認定住所()));
        }
        div.getTxtNinteiChosaTelNo().setDomain(konkaiDataPass.get認定電話番号());
        div.getTxtNinteiChosaIraiDate().setValue(konkaiDataPass.get認定調査依頼年月日());
        div.getTxtNinteiChosaJisshiYoteiDate().setValue(konkaiDataPass.get認定調査予定年月日());
        div.getTxtNinteiChosaJisshiDate().setValue(konkaiDataPass.get認定調査実施年月日());
        div.getDdlNinteiChosaItakusakiKubun().setIsBlankLine(true);
        if (konkaiDataPass.get調査委託区分() != null && !konkaiDataPass.get調査委託区分().isEmpty()) {
            div.getDdlNinteiChosaItakusakiKubun().setSelectedKey(konkaiDataPass.get調査委託区分());
        }
        if (konkaiDataPass.get訪問調査先名称() != null && !konkaiDataPass.get訪問調査先名称().isEmpty()) {
            div.getTxtChosasakiName().setValue(konkaiDataPass.get訪問調査先名称().value());
        }
        div.getTxtChosasakiYubinNo().setValue(konkaiDataPass.get訪問調査先郵便番号());
        div.getTxtChosasakiJusho().setDomain(konkaiDataPass.get訪問調査先住所());
        div.getTxtChosasakiTelNo().setDomain(konkaiDataPass.get訪問調査先電話番号());
        div.getTxtShujiiCode().setValue(konkaiDataPass.get主治医コード());
        div.getTxtShujiiName().setValue(konkaiDataPass.get主治医氏名());
        div.getTxtShujiiIryoKikanCode().setValue(konkaiDataPass.get主治医医療機関コード());
        div.getTxtShujiiIryoKikanName().setValue(konkaiDataPass.get医療機関名称());
        div.getTxtShujiiIryoKikanYubinNo().setValue(konkaiDataPass.get主治医郵便番号());
        if (konkaiDataPass.get主治医住所() != null && !konkaiDataPass.get主治医住所().isEmpty()) {
            div.getTxtShujiiIryoKikanJusho().setDomain(new AtenaJusho(konkaiDataPass.get主治医住所()));
        }
        div.getTxtShujiiIryoKikanTelNo().setDomain(konkaiDataPass.get主治医電話番号());
        div.getTxtShujiiIryoKikanIraiDate().setValue(konkaiDataPass.get主治医意見書作成依頼年月日());
        div.getTxtShujiiIryoKikanNyushuYoteiDate().setValue(konkaiDataPass.get主治医意見書登録予定年月日());
        div.getTxtShujiiIryoKikanNyushuDate().setValue(konkaiDataPass.get主治医意見書記入年月日());
        if (konkaiDataPass.is指定医フラグ()) {
            List<RString> selectKey = new ArrayList<>();
            selectKey.add(new RString("key0"));
            div.getChkShujiiKubun().setSelectedItemsByKey(selectKey);
        }
        div.getDdlYokaigodo().setIsBlankLine(true);
        if (konkaiDataPass.get要介護認定一次判定結果コード() != null && !konkaiDataPass.get要介護認定一次判定結果コード().isEmpty()) {
            div.getDdlYokaigodo().setSelectedKey(konkaiDataPass.get要介護認定一次判定結果コード().value());
        }
        div.getDdlNinchishoKasangoYokaigodo().setIsBlankLine(true);
        div.getTxtIchijiHanteiDate().setValue(konkaiDataPass.get要介護認定一次判定年月日());
        if (konkaiDataPass.get要介護認定一次判定結果コード_認知症加算() != null
                && !konkaiDataPass.get要介護認定一次判定結果コード_認知症加算().isEmpty()) {
            div.getDdlNinchishoKasangoYokaigodo().setSelectedKey(konkaiDataPass.get要介護認定一次判定結果コード_認知症加算().value());
        }
        div.getTxtShinsakaiShiryoSakuseiDate().setValue(konkaiDataPass.get介護認定審査会資料作成年月日());
        div.getTxtShinsakaiKaisaiYoteiDate().setValue(konkaiDataPass.get認定審査会予定年月日());
        div.getTxtNijiHanteiDate().setValue(konkaiDataPass.get二次判定年月日());
        div.getDdlNijiHanteiKekka().setIsBlankLine(true);
        if (konkaiDataPass.get二次判定要介護状態区分コード() != null
                && !konkaiDataPass.get二次判定要介護状態区分コード().isEmpty()) {
            div.getDdlNijiHanteiKekka().setSelectedKey(konkaiDataPass.get二次判定要介護状態区分コード().value());
        }
        div.getTxtNijiHanteiYukoKikan().setValue(new RString(konkaiDataPass.get二次判定認定有効期間()));
        div.getTxtNinteiYukoKikanFrom().setValue(konkaiDataPass.get二次判定認定有効開始年月日());
        div.getTxtNinteiYukoKikanTo().setValue(konkaiDataPass.get二次判定認定有効終了年月日());
        div.getTxtEnkiTsuchiHakkoDay().setValue(konkaiDataPass.get延期通知発行年月日());
        div.getTxtEnkiTsuchiHakkoCount().setValue(new Decimal(konkaiDataPass.get延期通知発行回数()));
    }
}
