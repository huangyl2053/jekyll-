/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010013;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010013.KinnkyuujiShisetsuRyouyouhiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010013.dgKinkyujiShisetsuRyoyohi_Row;
import jp.co.ndensan.reams.db.dbx.business.util.DateConverter;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 緊急時施設療養費のHandlerです。
 *
 * @reamsid_L DBC-2970-050 wangrenze
 */
public class KinnkyuujiShisetsuRyouyouhiHandler {

    private final KinnkyuujiShisetsuRyouyouhiDiv div;
    private static final RString DISABLED = new RString("0");

    /**
     * 初期化
     *
     * @param div KinnkyuujiShisetsuRyouyouhiDiv
     */
    public KinnkyuujiShisetsuRyouyouhiHandler(KinnkyuujiShisetsuRyouyouhiDiv div) {
        this.div = div;
    }

    /**
     * 画面のデータを初期化する。
     *
     * @param 給付実績緊急時施設療養データ取得 List<KyufujissekiKinkyuShisetsuRyoyo>
     */
    public void onLoad(List<KyufujissekiKinkyuShisetsuRyoyo> 給付実績緊急時施設療養データ取得) {
        List<dgKinkyujiShisetsuRyoyohi_Row> rowList = new ArrayList<>();
        int size = 給付実績緊急時施設療養データ取得.size();
        for (int index = 0; index < size; index++) {
            rowList.add(getデータ(index, 給付実績緊急時施設療養データ取得));
            rowList.add(get後のデータ(index, 給付実績緊急時施設療養データ取得));
        }
        div.getDgKinkyujiShisetsuRyoyohi().setDataSource(rowList);
    }

    private dgKinkyujiShisetsuRyoyohi_Row getデータ(int index, List<KyufujissekiKinkyuShisetsuRyoyo> 給付実績情報) {
        dgKinkyujiShisetsuRyoyohi_Row row = new dgKinkyujiShisetsuRyoyohi_Row();
        row.setTxtKinkyuKubun(給付実績情報.get(index).get緊急時施設療養情報レコード順次番号());
        row.getTxtShobyoName().setValue(set緊急時傷病名(給付実績情報.get(index)));
        row.getTxtChiryoKaishiYMD().setValue(set緊急時治療開始年月日(給付実績情報.get(index)));
        row.setTxtKettei(RString.EMPTY);
        row.setTxtOshinIryoKikanName(給付実績情報.get(index).get往診医療機関名());
        row.setTxtOshinNissu(new RString(給付実績情報.get(index).get往診日数()));
        row.setTxtTsuinIryoKikanName(給付実績情報.get(index).get通院医療機関名());
        row.setTxtTsuinNissu(new RString(給付実績情報.get(index).get通院日数()));
        row.setTxtKanriShokei(new RString(給付実績情報.get(index).get緊急時治療管理小計()));
        row.setTxtKanriTani(new RString(給付実績情報.get(index).get緊急時治療管理単位数()));
        row.setTxtKanriNissu(new RString(給付実績情報.get(index).get緊急時治療管理日数()));
        row.setTxtGokeiTensu(new RString(給付実績情報.get(index).get緊急時施設療養費合計点数()));
        row.setTxtRehabilitationTensu(new RString(給付実績情報.get(index).getリハビリテーション点数()));
        row.setTxtShochiTensu(new RString(給付実績情報.get(index).get処置点数()));
        row.setTxtShujutsuTensu(new RString(給付実績情報.get(index).get手術点数()));
        row.setTxtMahiTensu(new RString(給付実績情報.get(index).get麻酔点数()));
        row.setTxtHoshasenChiryoTensu(new RString(給付実績情報.get(index).get放射線治療点数()));
        row.setTxtSaiShinsaKaisu(new RString(給付実績情報.get(index).get再審査回数()));
        row.setTxtKagoKaisu(new RString(給付実績情報.get(index).get過誤回数()));
        if (給付実績情報.get(index).get審査年月() != null && !給付実績情報.get(index).get審査年月().isEmpty()) {
            row.setTxtShinsaYM(DateConverter.toWarekiHalf_Zero(new RYearMonth(給付実績情報.get(index).get審査年月().toString())));
        } else {
            row.setTxtShinsaYM(RString.EMPTY);
        }
        row.setTxtTekiyo1(給付実績情報.get(index).get摘要１());
        row.setTxtTekiyo2(給付実績情報.get(index).get摘要２());
        row.setTxtTekiyo3(給付実績情報.get(index).get摘要３());
        row.setTxtTekiyo4(給付実績情報.get(index).get摘要４());
        row.setTxtTekiyo5(給付実績情報.get(index).get摘要５());
        row.setTxtTekiyo6(給付実績情報.get(index).get摘要６());
        row.setTxtTekiyo7(給付実績情報.get(index).get摘要７());
        row.setTxtTekiyo8(給付実績情報.get(index).get摘要８());
        row.setTxtTekiyo9(給付実績情報.get(index).get摘要９());
        row.setTxtTekiyo10(給付実績情報.get(index).get摘要１０());
        row.setTxtTekiyo11(給付実績情報.get(index).get摘要１１());
        row.setTxtTekiyo12(給付実績情報.get(index).get摘要１２());
        row.setTxtTekiyo13(給付実績情報.get(index).get摘要１３());
        row.setTxtTekiyo14(給付実績情報.get(index).get摘要１４());
        row.setTxtTekiyo15(給付実績情報.get(index).get摘要１５());
        row.setTxtTekiyo16(給付実績情報.get(index).get摘要１６());
        row.setTxtTekiyo17(給付実績情報.get(index).get摘要１７());
        row.setTxtTekiyo18(給付実績情報.get(index).get摘要１８());
        row.setTxtTekiyo19(給付実績情報.get(index).get摘要１９());
        row.setTxtTekiyo20(給付実績情報.get(index).get摘要２０());
        return row;

    }

    private dgKinkyujiShisetsuRyoyohi_Row get後のデータ(int index, List<KyufujissekiKinkyuShisetsuRyoyo> 給付実績情報) {
        dgKinkyujiShisetsuRyoyohi_Row row = new dgKinkyujiShisetsuRyoyohi_Row();
        row.setTxtKinkyuKubun(RString.EMPTY);
        row.getTxtShobyoName().setValue(RString.EMPTY);
        row.getTxtChiryoKaishiYMD().setValue(RString.EMPTY);
        row.setTxtKettei(new RString("後"));
        row.setTxtOshinNissu(new RString(給付実績情報.get(index).get後_往診日数()));
        row.setTxtTsuinNissu(new RString(給付実績情報.get(index).get後_通院日数()));
        row.setTxtKanriTani(new RString(給付実績情報.get(index).get後_緊急時治療管理単位数()));
        row.setTxtKanriNissu(new RString(給付実績情報.get(index).get後_緊急時治療管理日数()));
        row.setTxtRehabilitationTensu(new RString(給付実績情報.get(index).get後_リハビリテーション点数()));
        row.setTxtShochiTensu(new RString(給付実績情報.get(index).get後_処置点数()));
        row.setTxtShujutsuTensu(new RString(給付実績情報.get(index).get後_手術点数()));
        row.setTxtMahiTensu(new RString(給付実績情報.get(index).get後_麻酔点数()));
        row.setTxtHoshasenChiryoTensu(new RString(給付実績情報.get(index).get後_放射線治療点数()));
        row.setTxtTekiyo1(給付実績情報.get(index).get摘要１());
        row.setTxtTekiyo2(給付実績情報.get(index).get摘要２());
        row.setTxtTekiyo3(給付実績情報.get(index).get摘要３());
        row.setTxtTekiyo4(給付実績情報.get(index).get摘要４());
        row.setTxtTekiyo5(給付実績情報.get(index).get摘要５());
        row.setTxtTekiyo6(給付実績情報.get(index).get摘要６());
        row.setTxtTekiyo7(給付実績情報.get(index).get摘要７());
        row.setTxtTekiyo8(給付実績情報.get(index).get摘要８());
        row.setTxtTekiyo9(給付実績情報.get(index).get摘要９());
        row.setTxtTekiyo10(給付実績情報.get(index).get摘要１０());
        row.setTxtTekiyo11(給付実績情報.get(index).get摘要１１());
        row.setTxtTekiyo12(給付実績情報.get(index).get摘要１２());
        row.setTxtTekiyo13(給付実績情報.get(index).get摘要１３());
        row.setTxtTekiyo14(給付実績情報.get(index).get摘要１４());
        row.setTxtTekiyo15(給付実績情報.get(index).get摘要１５());
        row.setTxtTekiyo16(給付実績情報.get(index).get摘要１６());
        row.setTxtTekiyo17(給付実績情報.get(index).get摘要１７());
        row.setTxtTekiyo18(給付実績情報.get(index).get摘要１８());
        row.setTxtTekiyo19(給付実績情報.get(index).get摘要１９());
        row.setTxtTekiyo20(給付実績情報.get(index).get摘要２０());
        return row;
    }

    /**
     * ボタン状態の設定です。
     *
     * @param 識別番号管理 ShikibetsuNoKanri
     */
    public void setButton(ShikibetsuNoKanri 識別番号管理) {

        if (DISABLED.equals(識別番号管理.get基本設定区分())) {
            div.getBtnKihon().setDisabled(true);
        } else {
            div.getBtnKihon().setDisabled(false);
        }
        if (DISABLED.equals(識別番号管理.get明細設定区分())) {
            div.getBtnMeisaiShukei().setDisabled(true);
        } else {
            div.getBtnMeisaiShukei().setDisabled(false);
        }
        if (DISABLED.equals(識別番号管理.get所定疾患施設療養設定区分())) {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(false);
        }
        div.getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
        if (DISABLED.equals(識別番号管理.get食事費用設定区分())) {
            div.getBtnShokuji().setDisabled(true);
        } else {
            div.getBtnShokuji().setDisabled(false);
        }
        if (DISABLED.equals(識別番号管理.get福祉用具購入費設定区分())) {
            div.getBtnFukushiYoguKonyu().setDisabled(true);
        } else {
            div.getBtnFukushiYoguKonyu().setDisabled(false);
        }
        add(識別番号管理);
    }

    private void add(ShikibetsuNoKanri 識別番号管理) {
        if (DISABLED.equals(識別番号管理.get特定入所者設定区分())) {
            div.getBtnTokuteiNyushosha().setDisabled(true);
        } else {
            div.getBtnTokuteiNyushosha().setDisabled(false);
        }
        div.getBtnKogakuKaigoService().setDisabled(true);
        if (DISABLED.equals(識別番号管理.get特定診療費設定区分())) {
            div.getBtnTokuteiShinryo().setDisabled(true);
        } else {
            div.getBtnTokuteiShinryo().setDisabled(false);
        }

        if (DISABLED.equals(識別番号管理.get居宅計画費設定区分())) {
            div.getBtnKyotakuServiceKeikaku().setDisabled(true);
        } else {
            div.getBtnKyotakuServiceKeikaku().setDisabled(false);
        }

        if (DISABLED.equals(識別番号管理.get住宅改修費設定区分())) {
            div.getBtnJutakuKaishu().setDisabled(true);
        } else {
            div.getBtnJutakuKaishu().setDisabled(false);
        }

        if (DISABLED.equals(識別番号管理.getケアマネジメント設定区分())) {
            div.getBtnCareManagement().setDisabled(true);
        } else {
            div.getBtnCareManagement().setDisabled(false);
        }

        if (DISABLED.equals(識別番号管理.get社会福祉法人軽減設定区分())) {
            div.getBtnShafukuKeigen().setDisabled(true);
        } else {
            div.getBtnShafukuKeigen().setDisabled(false);
        }
    }

    /**
     * パネル状態の設定です。
     *
     */
    public void checkState() {
        div.getKyufuJissekiTekiyoPanel().setIsOpen(false);
    }

    /**
     * パネル状態の設定です。
     *
     */
    public void changeState() {
        div.getKyufuJissekiTekiyoPanel().setIsOpen(true);
    }

    /**
     * 摘要データの設定です。
     *
     * @param 給付実績情報 dgKinkyujiShisetsuRyoyohi_Row
     * @return 摘要データ 摘要データ
     */
    public RString set摘要データ(dgKinkyujiShisetsuRyoyohi_Row 給付実績情報) {
        RStringBuilder 摘要データ = new RStringBuilder();
        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo1())) {
            摘要データ.append(給付実績情報.getTxtTekiyo1().trim()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo2())) {
            摘要データ.append(給付実績情報.getTxtTekiyo2().trim()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo3())) {
            摘要データ.append(給付実績情報.getTxtTekiyo3().trim()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo4())) {
            摘要データ.append(給付実績情報.getTxtTekiyo4().trim()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo5())) {
            摘要データ.append(給付実績情報.getTxtTekiyo5().trim()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo6())) {
            摘要データ.append(給付実績情報.getTxtTekiyo6()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo7())) {
            摘要データ.append(給付実績情報.getTxtTekiyo7()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo8())) {
            摘要データ.append(給付実績情報.getTxtTekiyo8()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo9())) {
            摘要データ.append(給付実績情報.getTxtTekiyo9()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo10())) {
            摘要データ.append(給付実績情報.getTxtTekiyo10()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo11())) {
            摘要データ.append(給付実績情報.getTxtTekiyo11()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo12())) {
            摘要データ.append(給付実績情報.getTxtTekiyo12()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo13())) {
            摘要データ.append(給付実績情報.getTxtTekiyo13()).append(NewLine.CRLF.getNewLineString());
        }
        add摘要データ(摘要データ, 給付実績情報);
        return 摘要データ.toRString();
    }

    private void add摘要データ(RStringBuilder 摘要データ, dgKinkyujiShisetsuRyoyohi_Row 給付実績情報) {
        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo14())) {
            摘要データ.append(給付実績情報.getTxtTekiyo14()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo15())) {
            摘要データ.append(給付実績情報.getTxtTekiyo15()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo16())) {
            摘要データ.append(給付実績情報.getTxtTekiyo16()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo17())) {
            摘要データ.append(給付実績情報.getTxtTekiyo17()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo18())) {
            摘要データ.append(給付実績情報.getTxtTekiyo18()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo19())) {
            摘要データ.append(給付実績情報.getTxtTekiyo19()).append(NewLine.CRLF.getNewLineString());
        }

        if (!RString.isNullOrEmpty(給付実績情報.getTxtTekiyo20())) {
            摘要データ.append(給付実績情報.getTxtTekiyo20()).append(NewLine.CRLF.getNewLineString());
        }

    }

    private RString set緊急時傷病名(KyufujissekiKinkyuShisetsuRyoyo 給付実績情報) {
        RStringBuilder 緊急時傷病名 = new RStringBuilder();
        if (RString.isNullOrEmpty(給付実績情報.get緊急時傷病名１())) {
            緊急時傷病名.append(NewLine.CRLF.getNewLineString());
        } else {
            緊急時傷病名.append(給付実績情報.get緊急時傷病名１())
                    .append(NewLine.CRLF.getNewLineString());
        }
        if (RString.isNullOrEmpty(給付実績情報.get緊急時傷病名２())) {
            緊急時傷病名.append(NewLine.CRLF.getNewLineString());
        } else {
            緊急時傷病名.append(給付実績情報.get緊急時傷病名２())
                    .append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(給付実績情報.get緊急時傷病名３())) {
            緊急時傷病名.append(給付実績情報.get緊急時傷病名３());
        }
        return 緊急時傷病名.toRString();
    }

    private RString set緊急時治療開始年月日(KyufujissekiKinkyuShisetsuRyoyo 給付実績情報) {
        RStringBuilder 緊急時治療開始年月日 = new RStringBuilder();
        if (給付実績情報.get緊急時治療開始年月日１() == null || 給付実績情報.get緊急時治療開始年月日１().isEmpty()
                || FlexibleDate.MIN.equals(給付実績情報.get緊急時治療開始年月日１())) {
            緊急時治療開始年月日.append(NewLine.CRLF.getNewLineString());
        } else {
            緊急時治療開始年月日.append(DateConverter.toWarekiHalf_Zero(new RDate(給付実績情報.get緊急時治療開始年月日１().toString())))
                    .append(NewLine.CRLF.getNewLineString());
        }
        if (給付実績情報.get緊急時治療開始年月日２() == null || 給付実績情報.get緊急時治療開始年月日２().isEmpty()
                || FlexibleDate.MIN.equals(給付実績情報.get緊急時治療開始年月日２())) {
            緊急時治療開始年月日.append(NewLine.CRLF.getNewLineString());
        } else {
            緊急時治療開始年月日.append(DateConverter.toWarekiHalf_Zero(new RDate(給付実績情報.get緊急時治療開始年月日２().toString())))
                    .append(NewLine.CRLF.getNewLineString());
        }
        if (給付実績情報.get緊急時治療開始年月日３() != null && !給付実績情報.get緊急時治療開始年月日３().isEmpty()
                && !FlexibleDate.MIN.equals(給付実績情報.get緊急時治療開始年月日３())) {
            緊急時治療開始年月日.append(DateConverter.toWarekiHalf_Zero(new RDate(給付実績情報.get緊急時治療開始年月日３().toString())));
        }
        return 緊急時治療開始年月日.toRString();
    }
}
