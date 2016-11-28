/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010014;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiShoteiShikkanShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010014.KinkyujiShisetsuRyoyohiShokaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010014.dgKinkyujiShisetsuRyoyohi_Row;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
     */
    public void setKinkyujiShisetsuRyoyohi(List<KyufujissekiShoteiShikkanShisetsuRyoyo> 所定疾患施設療養費等データリスト) {
        List<dgKinkyujiShisetsuRyoyohi_Row> rowList = new ArrayList<>();
        for (KyufujissekiShoteiShikkanShisetsuRyoyo 所定疾患施設療養費等 : 所定疾患施設療養費等データリスト) {
            rowList.add(setRow(所定疾患施設療養費等));
            rowList.add(setRow_後(所定疾患施設療養費等));
        }
        div.getDgKinkyujiShisetsuRyoyohi().setDataSource(rowList);
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
     */
    public void setButton(ShikibetsuNoKanri 識別番号管理) {
        if (ZERO.equals(識別番号管理.get基本設定区分())) {
            div.getBtnKihon().setDisabled(true);
        } else {
            div.getBtnKihon().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get明細設定区分()) && ZERO.equals(識別番号管理.get集計設定区分())) {
            div.getBtnMeisaiShukei().setDisabled(true);
        } else {
            div.getBtnMeisaiShukei().setDisabled(false);
        }
        div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(true);
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
        div.getBtnKogakuKaigoService().setDisabled(true);
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
                || 所定疾患施設療養費等データ.get所定疾患施設療養費開始年月日１().isEmpty()
                || FlexibleDate.MIN.equals(所定疾患施設療養費等データ.get所定疾患施設療養費開始年月日１())) {
            所定疾患施設療養費開始年月日.append(NewLine.CRLF.getNewLineString());
        } else {
            所定疾患施設療養費開始年月日.append(所定疾患施設療養費等データ.get所定疾患施設療養費開始年月日１().wareki().toDateString())
                    .append(NewLine.CRLF.getNewLineString());
        }
        if (所定疾患施設療養費等データ.get所定疾患施設療養費開始年月日２() == null
                || 所定疾患施設療養費等データ.get所定疾患施設療養費開始年月日２().isEmpty()
                || FlexibleDate.MIN.equals(所定疾患施設療養費等データ.get所定疾患施設療養費開始年月日２())) {
            所定疾患施設療養費開始年月日.append(NewLine.CRLF.getNewLineString());
        } else {
            所定疾患施設療養費開始年月日.append(所定疾患施設療養費等データ.get所定疾患施設療養費開始年月日２().wareki().toDateString())
                    .append(NewLine.CRLF.getNewLineString());
        }
        if (所定疾患施設療養費等データ.get所定疾患施設療養費開始年月日３() != null
                && !所定疾患施設療養費等データ.get所定疾患施設療養費開始年月日３().isEmpty()
                && !FlexibleDate.MIN.equals(所定疾患施設療養費等データ.get所定疾患施設療養費開始年月日３())) {
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
        if (所定疾患施設療養費等データ.get緊急時治療開始年月日１() == null || 所定疾患施設療養費等データ.get緊急時治療開始年月日１().isEmpty()
                || FlexibleDate.MIN.equals(所定疾患施設療養費等データ.get緊急時治療開始年月日１())) {
            緊急時治療開始年月日.append(NewLine.CRLF.getNewLineString());
        } else {
            緊急時治療開始年月日.append(所定疾患施設療養費等データ.get緊急時治療開始年月日１().wareki().toDateString())
                    .append(NewLine.CRLF.getNewLineString());
        }
        if (所定疾患施設療養費等データ.get緊急時治療開始年月日２() == null || 所定疾患施設療養費等データ.get緊急時治療開始年月日２().isEmpty()
                || FlexibleDate.MIN.equals(所定疾患施設療養費等データ.get緊急時治療開始年月日２())) {
            緊急時治療開始年月日.append(NewLine.CRLF.getNewLineString());
        } else {
            緊急時治療開始年月日.append(所定疾患施設療養費等データ.get緊急時治療開始年月日２().wareki().toDateString())
                    .append(NewLine.CRLF.getNewLineString());
        }
        if (所定疾患施設療養費等データ.get緊急時治療開始年月日３() != null && !所定疾患施設療養費等データ.get緊急時治療開始年月日３().isEmpty()
                && !FlexibleDate.MIN.equals(所定疾患施設療養費等データ.get緊急時治療開始年月日３())) {
            緊急時治療開始年月日.append(所定疾患施設療養費等データ.get緊急時治療開始年月日３().wareki().toDateString());
        }
        return 緊急時治療開始年月日.toRString();
    }
}
