/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010014;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiShoteiShikkanShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho2;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010014.KinkyujiShisetsuRyoyohiShokaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010014.dgKinkyujiShisetsuRyoyohi_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 給付実績の所定疾患施設療養費を照会の画面処理Handlerクラスです。
 *
 * @reamsid_L DBC-2970-060 zhaoyao
 */
public class KinkyujiShisetsuRyoyohiShokaiHandler {

    private final KinkyujiShisetsuRyoyohiShokaiDiv div;
    private static final RString 後 = new RString("後");
    private static final RString ZERO = new RString("0");
    private static final RString 前事業者 = new RString("前事業者");
    private static final RString 前月 = new RString("前月");
    private static final int INT_ZERO = 0;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public KinkyujiShisetsuRyoyohiShokaiHandler(KinkyujiShisetsuRyoyohiShokaiDiv div) {
        this.div = div;
    }

    /**
     * 所定疾患施設療養費等データの設定です。
     *
     * @param 所定疾患施設療養費等データリスト 所定疾患施設療養費等データリスト
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param サービス提供年月 サービス提供年月
     */
    public void setKinkyujiShisetsuRyoyohi(List<KyufujissekiShoteiShikkanShisetsuRyoyo> 所定疾患施設療養費等データリスト,
            RString 整理番号, RString 事業者番号, RString 様式番号, RString サービス提供年月) {
        List<dgKinkyujiShisetsuRyoyohi_Row> rowList = new ArrayList<>();
        List<dgKinkyujiShisetsuRyoyohi_Row> rowListKo = new ArrayList<>();
        List<KyufujissekiShoteiShikkanShisetsuRyoyo> 所定疾患施設療養費等データ
                = get給付実績データ(所定疾患施設療養費等データリスト, 整理番号, 事業者番号, 様式番号, サービス提供年月);
        for (KyufujissekiShoteiShikkanShisetsuRyoyo 所定疾患施設療養費等 : 所定疾患施設療養費等データ) {
            rowList.add(setRow(所定疾患施設療養費等));
        }
        for (KyufujissekiShoteiShikkanShisetsuRyoyo 所定疾患施設療養費等 : 所定疾患施設療養費等データ) {
            rowListKo.add(setRow_後(所定疾患施設療養費等));
        }
        rowList.addAll(rowListKo);
        div.getDgKinkyujiShisetsuRyoyohi().setDataSource(rowList);
        setGetsuBtn(getサービス提供年月リスト(所定疾患施設療養費等データリスト), new FlexibleYearMonth(サービス提供年月));
    }

    private dgKinkyujiShisetsuRyoyohi_Row setRow(KyufujissekiShoteiShikkanShisetsuRyoyo 所定疾患施設療養費等データ) {

        dgKinkyujiShisetsuRyoyohi_Row row = new dgKinkyujiShisetsuRyoyohi_Row();

        row.setTxtKinkyuKubun(所定疾患施設療養費等データ.get緊急時施設療養情報レコード順次番号());
        row.getTxtShobyoName().setValue(set所定疾患施設療養費傷病名(所定疾患施設療養費等データ));
        row.getTxtChiryoKaishiYMD().setValue(set所定疾患施設療養費開始年月日(所定疾患施設療養費等データ));
        row.getTxtKinkyujiShobyoName().setValue(set緊急時傷病名(所定疾患施設療養費等データ));
        row.getTxtIryoKaishiYMD().setValue(set緊急時治療開始年月日(所定疾患施設療養費等データ));
        row.setTxtKettei(RString.EMPTY);
        row.setTxtOshinIryoKikanName(所定疾患施設療養費等データ.get往診医療機関名());
        row.setTxtOshinNissu(new RString(所定疾患施設療養費等データ.get往診日数()));
        row.setTxtTsuinIryoKikanName(所定疾患施設療養費等データ.get通院医療機関名());
        row.setTxtTsuinNissu(new RString(所定疾患施設療養費等データ.get通院日数()));
        row.setTxtRyoyohiShokei(new RString(所定疾患施設療養費等データ.get所定疾患施設療養費小計()));
        row.setTxtRyoyohiTani(new RString(所定疾患施設療養費等データ.get所定疾患施設療養費単位数()));
        row.setTxtRyoyohiNissu(new RString(所定疾患施設療養費等データ.get所定疾患施設療養費日数()));
        row.setTxtKanriShokei(new RString(所定疾患施設療養費等データ.get緊急時治療管理小計()));
        row.setTxtKanriTani(new RString(所定疾患施設療養費等データ.get緊急時治療管理単位数()));
        row.setTxtKanriNissu(new RString(所定疾患施設療養費等データ.get緊急時治療管理日数()));
        row.setTxtGokeiTensu(new RString(所定疾患施設療養費等データ.get緊急時施設療養費合計点数()));
        row.setTxtRehabilitationTensu(new RString(所定疾患施設療養費等データ.getリハビリテーション点数()));
        row.setTxtShochiTensu(new RString(所定疾患施設療養費等データ.get処置点数()));
        row.setTxtShujutsuTensu(new RString(所定疾患施設療養費等データ.get手術点数()));
        row.setTxtMahiTensu(new RString(所定疾患施設療養費等データ.get麻酔点数()));
        row.setTxtHoshasenChiryoTensu(new RString(所定疾患施設療養費等データ.get放射線治療点数()));
        row.setTxtSaiShinsaKaisu(new RString(所定疾患施設療養費等データ.get再審査回数()));
        row.setTxtKagoKaisu(new RString(所定疾患施設療養費等データ.get過誤回数()));
        row.setTxtShinsaYM(所定疾患施設療養費等データ.get審査年月().wareki().toDateString());
        row.setTxtTekiyo(set摘要_前(所定疾患施設療養費等データ).append(set摘要_後(所定疾患施設療養費等データ)).toRString());
        return row;
    }

    private dgKinkyujiShisetsuRyoyohi_Row setRow_後(KyufujissekiShoteiShikkanShisetsuRyoyo 所定疾患施設療養費等データ) {

        dgKinkyujiShisetsuRyoyohi_Row row_後 = new dgKinkyujiShisetsuRyoyohi_Row();

        row_後.setTxtKinkyuKubun(RString.EMPTY);
        row_後.getTxtShobyoName().setValue(RString.EMPTY);
        row_後.getTxtChiryoKaishiYMD().setValue(RString.EMPTY);
        row_後.getTxtKinkyujiShobyoName().setValue(RString.EMPTY);
        row_後.getTxtIryoKaishiYMD().setValue(RString.EMPTY);
        row_後.setTxtKettei(後);
        row_後.setTxtOshinIryoKikanName(所定疾患施設療養費等データ.get往診医療機関名());
        row_後.setTxtOshinNissu(new RString(所定疾患施設療養費等データ.get往診日数()));
        row_後.setTxtTsuinIryoKikanName(所定疾患施設療養費等データ.get通院医療機関名());
        row_後.setTxtTsuinNissu(new RString(所定疾患施設療養費等データ.get通院日数()));
        row_後.setTxtRyoyohiShokei(new RString(所定疾患施設療養費等データ.get所定疾患施設療養費小計()));
        row_後.setTxtRyoyohiTani(new RString(所定疾患施設療養費等データ.get後_所定疾患施設療養費単位数()));
        row_後.setTxtRyoyohiNissu(new RString(所定疾患施設療養費等データ.get後_所定疾患施設療養費日数()));
        row_後.setTxtKanriShokei(new RString(所定疾患施設療養費等データ.get緊急時治療管理小計()));
        row_後.setTxtKanriTani(new RString(所定疾患施設療養費等データ.get後_緊急時治療管理単位数()));
        row_後.setTxtKanriNissu(new RString(所定疾患施設療養費等データ.get後_緊急時治療管理日数()));
        row_後.setTxtGokeiTensu(new RString(所定疾患施設療養費等データ.get緊急時施設療養費合計点数()));
        row_後.setTxtRehabilitationTensu(new RString(所定疾患施設療養費等データ.get後_リハビリテーション点数()));
        row_後.setTxtShochiTensu(new RString(所定疾患施設療養費等データ.get後_処置点数()));
        row_後.setTxtShujutsuTensu(new RString(所定疾患施設療養費等データ.get後_手術点数()));
        row_後.setTxtMahiTensu(new RString(所定疾患施設療養費等データ.get後_麻酔点数()));
        row_後.setTxtHoshasenChiryoTensu(new RString(所定疾患施設療養費等データ.get後_放射線治療点数()));
        row_後.setTxtSaiShinsaKaisu(new RString(所定疾患施設療養費等データ.get再審査回数()));
        row_後.setTxtKagoKaisu(new RString(所定疾患施設療養費等データ.get過誤回数()));
        row_後.setTxtShinsaYM(所定疾患施設療養費等データ.get審査年月().wareki().toDateString());
        row_後.setTxtTekiyo(set摘要_前(所定疾患施設療養費等データ).append(set摘要_後(所定疾患施設療養費等データ)).toRString());
        return row_後;
    }

    private RStringBuilder set摘要_前(KyufujissekiShoteiShikkanShisetsuRyoyo 所定疾患施設療養費等データ) {
        RStringBuilder 摘要 = new RStringBuilder();
        if (!RString.isNullOrEmpty(所定疾患施設療養費等データ.get摘要１().trim())) {
            摘要.append(所定疾患施設療養費等データ.get摘要１().trim()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(所定疾患施設療養費等データ.get摘要２().trim())) {
            摘要.append(所定疾患施設療養費等データ.get摘要２().trim()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(所定疾患施設療養費等データ.get摘要３().trim())) {
            摘要.append(所定疾患施設療養費等データ.get摘要３().trim()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(所定疾患施設療養費等データ.get摘要４().trim())) {
            摘要.append(所定疾患施設療養費等データ.get摘要４().trim()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(所定疾患施設療養費等データ.get摘要５().trim())) {
            摘要.append(所定疾患施設療養費等データ.get摘要５().trim()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(所定疾患施設療養費等データ.get摘要６().trim())) {
            摘要.append(所定疾患施設療養費等データ.get摘要６().trim()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(所定疾患施設療養費等データ.get摘要７().trim())) {
            摘要.append(所定疾患施設療養費等データ.get摘要７().trim()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(所定疾患施設療養費等データ.get摘要８().trim())) {
            摘要.append(所定疾患施設療養費等データ.get摘要８().trim()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(所定疾患施設療養費等データ.get摘要９().trim())) {
            摘要.append(所定疾患施設療養費等データ.get摘要９().trim()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(所定疾患施設療養費等データ.get摘要１０().trim())) {
            摘要.append(所定疾患施設療養費等データ.get摘要１０().trim()).append(NewLine.CRLF.getNewLineString());
        }

        return 摘要;
    }

    private RString set摘要_後(KyufujissekiShoteiShikkanShisetsuRyoyo 所定疾患施設療養費等データ) {
        RStringBuilder 摘要 = new RStringBuilder();
        if (!RString.isNullOrEmpty(所定疾患施設療養費等データ.get摘要１１().trim())) {
            摘要.append(所定疾患施設療養費等データ.get摘要１１().trim()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(所定疾患施設療養費等データ.get摘要１２().trim())) {
            摘要.append(所定疾患施設療養費等データ.get摘要１２().trim()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(所定疾患施設療養費等データ.get摘要１３().trim())) {
            摘要.append(所定疾患施設療養費等データ.get摘要１３().trim()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(所定疾患施設療養費等データ.get摘要１４().trim())) {
            摘要.append(所定疾患施設療養費等データ.get摘要１４().trim()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(所定疾患施設療養費等データ.get摘要１５().trim())) {
            摘要.append(所定疾患施設療養費等データ.get摘要１５().trim()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(所定疾患施設療養費等データ.get摘要１６().trim())) {
            摘要.append(所定疾患施設療養費等データ.get摘要１６().trim()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(所定疾患施設療養費等データ.get摘要１７().trim())) {
            摘要.append(所定疾患施設療養費等データ.get摘要１７().trim()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(所定疾患施設療養費等データ.get摘要１８().trim())) {
            摘要.append(所定疾患施設療養費等データ.get摘要１８().trim()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(所定疾患施設療養費等データ.get摘要１９().trim())) {
            摘要.append(所定疾患施設療養費等データ.get摘要１９().trim()).append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(所定疾患施設療養費等データ.get摘要２０().trim())) {
            摘要.append(所定疾患施設療養費等データ.get摘要２０().trim());
        }
        return 摘要.toRString();
    }

    /**
     * ボタン状態の設定です。
     *
     * @param 識別番号管理 識別番号管理
     * @param サービス提供年月 サービス提供年月
     */
    public void setButton(ShikibetsuNoKanri 識別番号管理, FlexibleYearMonth サービス提供年月) {
        if (ZERO.equals(識別番号管理.get基本設定区分())) {
            div.getBtnKihon().setDisabled(true);
        } else {
            div.getBtnKihon().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get明細設定区分())) {
            div.getBtnMeisaiShukei().setDisabled(true);
        } else {
            div.getBtnMeisaiShukei().setDisabled(false);
        }
        div.getBtnShoteiShikkanShisetsuRyoyo().setDisplayNone(true);
        if (ZERO.equals(識別番号管理.get緊急時施設療養設定区分())) {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get食事費用設定区分())) {
            div.getBtnShokuji().setDisabled(true);
        } else {
            div.getBtnShokuji().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get福祉用具購入費設定区分())) {
            div.getBtnFukushiYoguKonyu().setDisabled(true);
        } else {
            div.getBtnFukushiYoguKonyu().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get特定入所者設定区分())) {
            div.getBtnTokuteiNyushosha().setDisabled(true);
        } else {
            div.getBtnTokuteiNyushosha().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get高額介護サービス費設定区分())) {
            div.getBtnKogakuKaigoService().setDisabled(true);
        } else {
            div.getBtnKogakuKaigoService().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get特定診療費設定区分())) {
            div.getBtnTokuteiShinryo().setDisabled(true);
        } else {
            div.getBtnTokuteiShinryo().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get居宅計画費設定区分())) {
            div.getBtnKyotakuServiceKeikaku().setDisabled(true);
        } else {
            div.getBtnKyotakuServiceKeikaku().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get住宅改修費設定区分())) {
            div.getBtnJutakuKaishu().setDisabled(true);
        } else {
            div.getBtnJutakuKaishu().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.getケアマネジメント設定区分())) {
            div.getBtnCareManagement().setDisabled(true);
        } else {
            div.getBtnCareManagement().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get社会福祉法人軽減設定区分())) {
            div.getBtnShafukuKeigen().setDisabled(true);
        } else {
            div.getBtnShafukuKeigen().setDisabled(false);
        }
    }

    private RString set所定疾患施設療養費傷病名(KyufujissekiShoteiShikkanShisetsuRyoyo 所定疾患施設療養費等データ) {
        RStringBuilder 所定疾患施設療養費傷病名 = new RStringBuilder();
        if (RString.isNullOrEmpty(所定疾患施設療養費等データ.get所定疾患施設療養費傷病名１())) {
            所定疾患施設療養費傷病名.append(NewLine.CRLF.getNewLineString());
        } else {
            所定疾患施設療養費傷病名.append(所定疾患施設療養費等データ.get所定疾患施設療養費傷病名１())
                    .append(NewLine.CRLF.getNewLineString());
        }
        if (RString.isNullOrEmpty(所定疾患施設療養費等データ.get所定疾患施設療養費傷病名２())) {
            所定疾患施設療養費傷病名.append(NewLine.CRLF.getNewLineString());
        } else {
            所定疾患施設療養費傷病名.append(所定疾患施設療養費等データ.get所定疾患施設療養費傷病名２())
                    .append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(所定疾患施設療養費等データ.get所定疾患施設療養費傷病名３())) {
            所定疾患施設療養費傷病名.append(所定疾患施設療養費等データ.get所定疾患施設療養費傷病名３());
        }
        return 所定疾患施設療養費傷病名.toRString();
    }

    private RString set所定疾患施設療養費開始年月日(KyufujissekiShoteiShikkanShisetsuRyoyo 所定疾患施設療養費等データ) {
        RStringBuilder 所定疾患施設療養費開始年月日 = new RStringBuilder();
        if (所定疾患施設療養費等データ.get所定疾患施設療養費開始年月日１() == null
                || 所定疾患施設療養費等データ.get所定疾患施設療養費開始年月日１().isEmpty()) {
            所定疾患施設療養費開始年月日.append(NewLine.CRLF.getNewLineString());
        } else {
            所定疾患施設療養費開始年月日.append(所定疾患施設療養費等データ.get所定疾患施設療養費開始年月日１().wareki().toDateString())
                    .append(NewLine.CRLF.getNewLineString());
        }
        if (所定疾患施設療養費等データ.get所定疾患施設療養費開始年月日２() == null
                || 所定疾患施設療養費等データ.get所定疾患施設療養費開始年月日２().isEmpty()) {
            所定疾患施設療養費開始年月日.append(NewLine.CRLF.getNewLineString());
        } else {
            所定疾患施設療養費開始年月日.append(所定疾患施設療養費等データ.get所定疾患施設療養費開始年月日２().wareki().toDateString())
                    .append(NewLine.CRLF.getNewLineString());
        }
        if (所定疾患施設療養費等データ.get所定疾患施設療養費開始年月日３() != null
                && !所定疾患施設療養費等データ.get所定疾患施設療養費開始年月日３().isEmpty()) {
            所定疾患施設療養費開始年月日.append(所定疾患施設療養費等データ.get所定疾患施設療養費開始年月日３().wareki().toDateString());
        }
        return 所定疾患施設療養費開始年月日.toRString();
    }

    private RString set緊急時傷病名(KyufujissekiShoteiShikkanShisetsuRyoyo 所定疾患施設療養費等データ) {
        RStringBuilder 緊急時傷病名 = new RStringBuilder();
        if (RString.isNullOrEmpty(所定疾患施設療養費等データ.get緊急時傷病名１())) {
            緊急時傷病名.append(NewLine.CRLF.getNewLineString());
        } else {
            緊急時傷病名.append(所定疾患施設療養費等データ.get緊急時傷病名１())
                    .append(NewLine.CRLF.getNewLineString());
        }
        if (RString.isNullOrEmpty(所定疾患施設療養費等データ.get緊急時傷病名２())) {
            緊急時傷病名.append(NewLine.CRLF.getNewLineString());
        } else {
            緊急時傷病名.append(所定疾患施設療養費等データ.get緊急時傷病名２())
                    .append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(所定疾患施設療養費等データ.get緊急時傷病名３())) {
            緊急時傷病名.append(所定疾患施設療養費等データ.get緊急時傷病名３());
        }
        return 緊急時傷病名.toRString();
    }

    private RString set緊急時治療開始年月日(KyufujissekiShoteiShikkanShisetsuRyoyo 所定疾患施設療養費等データ) {
        RStringBuilder 緊急時治療開始年月日 = new RStringBuilder();
        if (所定疾患施設療養費等データ.get緊急時治療開始年月日１() == null || 所定疾患施設療養費等データ.get緊急時治療開始年月日１().isEmpty()) {
            緊急時治療開始年月日.append(NewLine.CRLF.getNewLineString());
        } else {
            緊急時治療開始年月日.append(所定疾患施設療養費等データ.get緊急時治療開始年月日１().wareki().toDateString())
                    .append(NewLine.CRLF.getNewLineString());
        }
        if (所定疾患施設療養費等データ.get緊急時治療開始年月日２() == null || 所定疾患施設療養費等データ.get緊急時治療開始年月日２().isEmpty()) {
            緊急時治療開始年月日.append(NewLine.CRLF.getNewLineString());
        } else {
            緊急時治療開始年月日.append(所定疾患施設療養費等データ.get緊急時治療開始年月日２().wareki().toDateString())
                    .append(NewLine.CRLF.getNewLineString());
        }
        if (所定疾患施設療養費等データ.get緊急時治療開始年月日３() != null && !所定疾患施設療養費等データ.get緊急時治療開始年月日３().isEmpty()) {
            緊急時治療開始年月日.append(所定疾患施設療養費等データ.get緊急時治療開始年月日３().wareki().toDateString());
        }
        return 緊急時治療開始年月日.toRString();
    }

    /**
     * change年月です。
     *
     * @param data フラグ
     * @param 整理番号 整理番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 識別番号 識別番号
     * @param 所定疾患施設療養費等データ取得リスト 所定疾患施設療養費等データ取得リスト
     */
    public void change年月(RString data, List<KyufujissekiShoteiShikkanShisetsuRyoyo> 所定疾患施設療養費等データ取得リスト,
            FlexibleYearMonth サービス提供年月, RString 整理番号, HihokenshaNo 被保険者番号, NyuryokuShikibetsuNo 識別番号) {
        List<dgKinkyujiShisetsuRyoyohi_Row> rowList = new ArrayList<>();
        int index = INT_ZERO;
        List<FlexibleYearMonth> サービス提供年月リスト = getサービス提供年月リスト(所定疾患施設療養費等データ取得リスト);
        Collections.sort(サービス提供年月リスト, new DateComparatorServiceTeikyoYM());
        for (int i = 0; i < サービス提供年月リスト.size(); i++) {
            if (サービス提供年月.equals(サービス提供年月リスト.get(i))) {
                index = i;
                break;
            }
        }
        FlexibleYearMonth 今提供年月 = FlexibleYearMonth.EMPTY;
        if (INT_ZERO < index && index < サービス提供年月リスト.size() - 1) {
            if (前月.equals(data)) {
                今提供年月 = サービス提供年月リスト.get(index + 1);
            } else {
                今提供年月 = サービス提供年月リスト.get(index - 1);
            }
        }
        List<KyufujissekiShoteiShikkanShisetsuRyoyo> 所定疾患施設療養費等データ取得
                = get給付実績データ(所定疾患施設療養費等データ取得リスト, div.getCcdKyufuJissekiHeader().get整理番号(),
                        div.getCcdKyufuJissekiHeader().get事業者番号(),
                        div.getCcdKyufuJissekiHeader().get様式番号(),
                        今提供年月.toDateString());
        div.getCcdKyufuJissekiHeader().initialize(被保険者番号, 今提供年月, 整理番号, 識別番号);
        for (KyufujissekiShoteiShikkanShisetsuRyoyo 所定疾患施設療養費等データ : 所定疾患施設療養費等データ取得) {
            rowList.add(setRow(所定疾患施設療養費等データ));
            rowList.add(setRow_後(所定疾患施設療養費等データ));
        }
        div.getDgKinkyujiShisetsuRyoyohi().setDataSource(rowList);
        setGetsuBtn(サービス提供年月リスト, 今提供年月);
    }

    /**
     * change事業者です。
     *
     * @param date 事業者フラグ
     * @param 事業者番号リスト 事業者番号リスト
     * @param 所定疾患施設療養費 所定疾患施設療養費
     */
    public void change事業者(RString date, List<KyufuJissekiHedajyoho2> 事業者番号リスト,
            List<KyufujissekiShoteiShikkanShisetsuRyoyo> 所定疾患施設療養費) {
        List<dgKinkyujiShisetsuRyoyohi_Row> rowList = new ArrayList<>();
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        RString 整理番号 = div.getCcdKyufuJissekiHeader().get整理番号();
        RString サービス提供年月 = div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString();
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        RString 実績区分コード = div.getCcdKyufuJissekiHeader().get実績区分コード();
        div.getBtnAtoJigyosha().setDisabled(true);
        div.getBtnMaeJigyosha().setDisabled(true);
        int index = get事業者番号index(事業者番号リスト, 整理番号, 事業者番号, 様式番号, サービス提供年月, 実績区分コード);
        int i;
        if (前事業者.equals(date)) {
            i = -1;
        } else {
            i = 1;
        }
        if (index + i < 事業者番号リスト.size() && -1 < index + i) {
            div.getCcdKyufuJissekiHeader().set事業者名称(事業者番号リスト.get(index + i).get事業者名称());
            div.getCcdKyufuJissekiHeader().set実績区分(事業者番号リスト.get(index + i).get給付実績区分コード());
            div.getCcdKyufuJissekiHeader().set整理番号(事業者番号リスト.get(index + i).get整理番号());
            div.getCcdKyufuJissekiHeader().set識別番号名称(事業者番号リスト.get(index + i).get識別番号名称());
            div.getCcdKyufuJissekiHeader().set事業者番号(事業者番号リスト.get(index + i).get事業所番号().value());
            div.getCcdKyufuJissekiHeader().set様式番号(事業者番号リスト.get(index + i).get識別番号());
            List<KyufujissekiShoteiShikkanShisetsuRyoyo> 所定疾患施設療養費等データ取得リスト
                    = get給付実績データ(所定疾患施設療養費, 事業者番号リスト.get(index + i).get整理番号(),
                            事業者番号リスト.get(index + i).get事業所番号().value(),
                            事業者番号リスト.get(index + i).get識別番号(),
                            事業者番号リスト.get(index + i).getサービス提供年月().toDateString());
            for (KyufujissekiShoteiShikkanShisetsuRyoyo 所定疾患施設療養費等データ取得 : 所定疾患施設療養費等データ取得リスト) {
                rowList.add(setRow(所定疾患施設療養費等データ取得));
                rowList.add(setRow_後(所定疾患施設療養費等データ取得));
            }
        }
        div.getDgKinkyujiShisetsuRyoyohi().setDataSource(rowList);
        if (0 < index + i) {
            div.getBtnMaeJigyosha().setDisabled(false);
        }
        if (index + i + 1 < 事業者番号リスト.size()) {
            div.getBtnAtoJigyosha().setDisabled(false);
        }
    }

    private List<KyufujissekiShoteiShikkanShisetsuRyoyo> get給付実績データ(List<KyufujissekiShoteiShikkanShisetsuRyoyo> 所定疾患施設療養費等データ取得,
            RString 整理番号, RString 事業者番号, RString 様式番号, RString サービス提供年月) {
        List<KyufujissekiShoteiShikkanShisetsuRyoyo> 所定疾患施設療養費等データ = new ArrayList<>();
        for (int index = 0; index < 所定疾患施設療養費等データ取得.size(); index++) {
            if (所定疾患施設療養費等データ取得.get(index).get事業所番号().value().equals(事業者番号)
                    && 整理番号.equals(所定疾患施設療養費等データ取得.get(index).get整理番号())
                    && 様式番号.equals(所定疾患施設療養費等データ取得.get(index).get入力識別番号().value())
                    && サービス提供年月.equals(所定疾患施設療養費等データ取得.get(index).getサービス提供年月().toDateString())) {
                所定疾患施設療養費等データ.add(所定疾患施設療養費等データ取得.get(index));
            }
        }
        return 所定疾患施設療養費等データ;
    }

    /**
     * 事業者番号の設定です。
     *
     * @param 事業者番号リスト List<KyufuJissekiHedajyoho2>
     * @param 整理番号 RString
     * @param 事業者番号 RString
     * @param 様式番号 RString
     * @param サービス提供年月 RString
     * @param 実績区分コード RString
     * @return index index
     */
    public int get事業者番号index(List<KyufuJissekiHedajyoho2> 事業者番号リスト, RString 整理番号, RString 事業者番号, RString 様式番号, RString サービス提供年月, RString 実績区分コード) {
        for (int index = 0; index < 事業者番号リスト.size(); index++) {
            if (事業者番号.equals(事業者番号リスト.get(index).get事業所番号().value())
                    && 整理番号.equals(事業者番号リスト.get(index).get整理番号())
                    && 様式番号.equals(事業者番号リスト.get(index).get識別番号())
                    && サービス提供年月.equals(事業者番号リスト.get(index).getサービス提供年月().toDateString())
                    && 実績区分コード.equals(事業者番号リスト.get(index).get給付実績区分コード())) {
                return index;
            }
        }
        return INT_ZERO;
    }

    /**
     * 事業者btnのstateです。
     *
     * @param 事業者番号リスト List<KyufuJissekiHedajyoho2>
     * @param 整理番号 RString
     * @param 様式番号 RString
     * @param 事業者番号 RString
     * @param サービス提供年月 RString
     * @param 実績区分コード RString
     */
    public void check事業者btn(List<KyufuJissekiHedajyoho2> 事業者番号リスト, RString 整理番号, RString 事業者番号,
            RString 様式番号, RString サービス提供年月, RString 実績区分コード) {
        if (!事業者番号リスト.isEmpty()) {
            div.getBtnMaeJigyosha().setDisabled(true);
            div.getBtnAtoJigyosha().setDisabled(true);
            int index = get事業者番号index(事業者番号リスト, 整理番号, 事業者番号, 様式番号, サービス提供年月, 実績区分コード);
            if (0 < index) {
                div.getBtnMaeJigyosha().setDisabled(false);
            }
            if (index + 1 < 事業者番号リスト.size()) {
                div.getBtnAtoJigyosha().setDisabled(false);
            }
        }
    }

    /**
     * 前次月ボタン状態設定。
     *
     * @param サービス提供年月リスト サービス提供年月リスト
     * @param サービス提供年月 サービス提供年月
     */
    public void setGetsuBtn(List<FlexibleYearMonth> サービス提供年月リスト, FlexibleYearMonth サービス提供年月) {
        Collections.sort(サービス提供年月リスト, new DateComparatorServiceTeikyoYM());

        if (サービス提供年月.isBeforeOrEquals(サービス提供年月リスト.get(サービス提供年月リスト.size() - 1))) {
            div.getBtnZengetsu().setDisabled(true);
        } else {
            div.getBtnZengetsu().setDisabled(false);
        }
        if (サービス提供年月リスト.get(INT_ZERO).isBeforeOrEquals(サービス提供年月)) {
            div.getBtnJigetsu().setDisabled(true);
        } else {
            div.getBtnJigetsu().setDisabled(false);
        }
    }

    private List<FlexibleYearMonth> getサービス提供年月リスト(List<KyufujissekiShoteiShikkanShisetsuRyoyo> 所定疾患施設療養費等データ取得リスト) {
        List<FlexibleYearMonth> 提供年月リスト = new ArrayList<>();
        for (KyufujissekiShoteiShikkanShisetsuRyoyo 所定疾患施設療養費等データ取得 : 所定疾患施設療養費等データ取得リスト) {
            FlexibleYearMonth 提供年月 = 所定疾患施設療養費等データ取得.getサービス提供年月();
            if (!提供年月リスト.contains(提供年月)) {
                提供年月リスト.add(提供年月);
            }
        }
        return 提供年月リスト;
    }

    private static class DateComparatorServiceTeikyoYM implements Comparator<FlexibleYearMonth>, Serializable {

        private static final long serialVersionUID = -4284918321684981470L;

        @Override
        public int compare(FlexibleYearMonth o1, FlexibleYearMonth o2) {
            return o2.compareTo(o1);
        }
    }
}
