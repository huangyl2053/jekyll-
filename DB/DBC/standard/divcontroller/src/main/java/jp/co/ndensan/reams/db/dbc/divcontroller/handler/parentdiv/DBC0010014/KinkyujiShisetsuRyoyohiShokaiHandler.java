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
    private static final RString NI = new RString("2");
    private static final FlexibleYearMonth 平成24年4月 = new FlexibleYearMonth("201204");
    private static final int YON = 4;

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
        for (KyufujissekiShoteiShikkanShisetsuRyoyo 所定疾患施設療養費等データ : 所定疾患施設療養費等データリスト) {

            dgKinkyujiShisetsuRyoyohi_Row row = new dgKinkyujiShisetsuRyoyohi_Row();

            row.setTxtKinkyuKubun(所定疾患施設療養費等データ.get緊急時施設療養情報レコード順次番号());
            row.getTxtIryoKaishiYMD().setValue(set所定疾患施設療養費傷病名(所定疾患施設療養費等データ));
            row.getTxtIryoKaishiYMD().setValue(set所定疾患施設療養費開始年月日(所定疾患施設療養費等データ));
            row.getTxtIryoKaishiYMD().setValue(set緊急時傷病名(所定疾患施設療養費等データ));
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
            row.setTxtShinsaYM(所定疾患施設療養費等データ.get審査年月().toDateString());
            row.setTxtTekiyo(set摘要_前(所定疾患施設療養費等データ).append(set摘要_後(所定疾患施設療養費等データ)).toRString());

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
            row_後.setTxtShinsaYM(所定疾患施設療養費等データ.get審査年月().toDateString());
            row_後.setTxtTekiyo(set摘要_前(所定疾患施設療養費等データ).append(set摘要_後(所定疾患施設療養費等データ)).toRString());

            rowList.add(row);
            rowList.add(row_後);
        }
        div.getDgKinkyujiShisetsuRyoyohi().setDataSource(rowList);
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
     * @param サービス提供年月 サービス提供年月
     */
    public void setButton(RString サービス提供年月) {
        ShikibetsuNoKanri 識別番号管理 = ShokanbaraiJyokyoShokai.createInstance().get識別番号管理データ().get(0);
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
        if (NI.equals(識別番号管理.get所定疾患施設療養設定区分())
                && 平成24年4月.isBeforeOrEquals(new FlexibleYearMonth(サービス提供年月))) {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisplayNone(false);
            div.getBtnKinkyujiShisetsuRyoyo().setDisplayNone(true);
        } else {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisplayNone(true);
            div.getBtnKinkyujiShisetsuRyoyo().setDisplayNone(false);
            if (ZERO.equals(識別番号管理.get緊急時施設療養設定区分())) {
                div.getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
            } else {
                div.getBtnKinkyujiShisetsuRyoyo().setDisabled(false);
            }
        }
        div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(true);
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

    /**
     * 前事業者ボタンを押します。
     *
     * @param 所定疾患施設療養費等データリスト 所定疾患施設療養費等データリスト
     * @param サービス提供年月 サービス提供年月
     * @param 事業者番号 事業者番号
     */
    public void to前事業者(List<KyufujissekiShoteiShikkanShisetsuRyoyo> 所定疾患施設療養費等データリスト, RString サービス提供年月, RString 事業者番号) {
        List<KyufujissekiShoteiShikkanShisetsuRyoyo> 所定疾患施設療養費等 = new ArrayList<>();
        List<KyufujissekiShoteiShikkanShisetsuRyoyo> 所定疾患テスト = new ArrayList<>();
        if (div.getKyufuJissekiTekiyoPanel().isIsOpen()) {
            div.getKyufuJissekiTekiyoPanel().setIsOpen(false);
        }
        事業者番号 = new RString(Integer.parseInt(事業者番号.toString()) - 1);
        RString 前事業者番号 = new RString(Integer.parseInt(事業者番号.toString()) - 2);
        for (KyufujissekiShoteiShikkanShisetsuRyoyo 所定疾患施設療養費等データ : 所定疾患施設療養費等データリスト) {
            if (事業者番号.equals(new RString(所定疾患施設療養費等データ.get事業所番号().toString()))
                    && サービス提供年月.contains(new RString(所定疾患施設療養費等データ.getサービス提供年月().toString()))) {
                所定疾患施設療養費等.add(所定疾患施設療養費等データ);
            }
            if (前事業者番号.equals(new RString(所定疾患施設療養費等データ.get事業所番号().toString()))
                    && サービス提供年月.contains(new RString(所定疾患施設療養費等データ.getサービス提供年月().toString()))) {
                所定疾患テスト.add(所定疾患施設療養費等データ);
            }
        }
        if (所定疾患テスト.isEmpty()) {
            div.getBtnZengetsu().setDisabled(false);
        }
        setKinkyujiShisetsuRyoyohi(所定疾患施設療養費等);
        //TODO 共有子div设值
    }

    /**
     * 後事業者ボタンを押します。
     *
     * @param 所定疾患施設療養費等データリスト 所定疾患施設療養費等データリスト
     * @param サービス提供年月 サービス提供年月
     * @param 事業者番号 事業者番号
     */
    public void to後事業者(List<KyufujissekiShoteiShikkanShisetsuRyoyo> 所定疾患施設療養費等データリスト, RString サービス提供年月, RString 事業者番号) {
        List<KyufujissekiShoteiShikkanShisetsuRyoyo> 所定疾患施設療養費等 = new ArrayList<>();
        List<KyufujissekiShoteiShikkanShisetsuRyoyo> 所定疾患テスト = new ArrayList<>();
        if (div.getKyufuJissekiTekiyoPanel().isIsOpen()) {
            div.getKyufuJissekiTekiyoPanel().setIsOpen(false);
        }
        事業者番号 = new RString(Integer.parseInt(事業者番号.toString()) + 1);
        RString 後事業者番号 = new RString(Integer.parseInt(事業者番号.toString()) + 2);
        for (KyufujissekiShoteiShikkanShisetsuRyoyo 所定疾患施設療養費等データ : 所定疾患施設療養費等データリスト) {
            if (事業者番号.equals(new RString(所定疾患施設療養費等データ.get事業所番号().toString()))
                    && サービス提供年月.contains(new RString(所定疾患施設療養費等データ.getサービス提供年月().toString()))) {
                所定疾患施設療養費等.add(所定疾患施設療養費等データ);
            }
            if (後事業者番号.equals(new RString(所定疾患施設療養費等データ.get事業所番号().toString()))
                    && サービス提供年月.contains(new RString(所定疾患施設療養費等データ.getサービス提供年月().toString()))) {
                所定疾患テスト.add(所定疾患施設療養費等データ);
            }
        }
        if (所定疾患テスト.isEmpty()) {
            div.getBtnAtoJigyosha().setDisabled(false);
        }
        setKinkyujiShisetsuRyoyohi(所定疾患施設療養費等);
        //TODO 共有子div设值
    }

    /**
     * 前月ボタンを押します。
     *
     * @param 所定疾患施設療養費等データリスト 所定疾患施設療養費等データリスト
     * @param サービス提供年月 サービス提供年月
     */
    public void to前月(List<KyufujissekiShoteiShikkanShisetsuRyoyo> 所定疾患施設療養費等データリスト, RString サービス提供年月) {
        List<KyufujissekiShoteiShikkanShisetsuRyoyo> 所定疾患施設療養費等 = new ArrayList<>();
        List<KyufujissekiShoteiShikkanShisetsuRyoyo> 所定疾患テスト = new ArrayList<>();
        if (div.getKyufuJissekiTekiyoPanel().isIsOpen()) {
            div.getKyufuJissekiTekiyoPanel().setIsOpen(false);
        }
        int サービス前月 = Integer.parseInt(サービス提供年月.substring(YON).toString()) - 1;
        int サービス前前月 = Integer.parseInt(サービス提供年月.substring(YON).toString()) - 2;
        for (KyufujissekiShoteiShikkanShisetsuRyoyo 所定疾患施設療養費等データ : 所定疾患施設療養費等データリスト) {
            RString 提供月 = new RString(所定疾患施設療養費等データ.getサービス提供年月().toString()).substring(YON);
            if (new RString(サービス前月).equals(提供月)) {
                所定疾患施設療養費等.add(所定疾患施設療養費等データ);
            }
            if (new RString(サービス前前月).equals(提供月)) {
                所定疾患テスト.add(所定疾患施設療養費等データ);
            }
        }
        if (所定疾患テスト.isEmpty()) {
            div.getBtnZengetsu().setDisabled(false);
        }
        setKinkyujiShisetsuRyoyohi(所定疾患施設療養費等);
        //TODO 共有子div设值
    }

    /**
     * 次月ボタンを押します。
     *
     * @param 所定疾患施設療養費等データリスト 所定疾患施設療養費等データリスト
     * @param サービス提供年月 サービス提供年月
     */
    public void to次月(List<KyufujissekiShoteiShikkanShisetsuRyoyo> 所定疾患施設療養費等データリスト, RString サービス提供年月) {
        List<KyufujissekiShoteiShikkanShisetsuRyoyo> 所定疾患施設療養費等 = new ArrayList<>();
        List<KyufujissekiShoteiShikkanShisetsuRyoyo> 所定疾患テスト = new ArrayList<>();
        if (div.getKyufuJissekiTekiyoPanel().isIsOpen()) {
            div.getKyufuJissekiTekiyoPanel().setIsOpen(false);
        }
        int サービス次月 = Integer.parseInt(サービス提供年月.substring(YON).toString()) + 1;
        int サービス次次月 = Integer.parseInt(サービス提供年月.substring(YON).toString()) + 2;
        for (KyufujissekiShoteiShikkanShisetsuRyoyo 所定疾患施設療養費等データ : 所定疾患施設療養費等データリスト) {
            RString 提供月 = new RString(所定疾患施設療養費等データ.getサービス提供年月().toString()).substring(YON);
            if (new RString(サービス次月).equals(提供月)) {
                所定疾患施設療養費等.add(所定疾患施設療養費等データ);
            }
            if (new RString(サービス次次月).equals(提供月)) {
                所定疾患テスト.add(所定疾患施設療養費等データ);
            }
        }
        if (所定疾患テスト.isEmpty()) {
            div.getBtnJigetsu().setDisabled(false);
        }
        setKinkyujiShisetsuRyoyohi(所定疾患施設療養費等);
        //TODO 共有子div设值
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
        if (RString.isNullOrEmpty(new RString(所定疾患施設療養費等データ.get所定疾患施設療養費開始年月日１().toString()))) {
            所定疾患施設療養費開始年月日.append(NewLine.CRLF.getNewLineString());
        } else {
            所定疾患施設療養費開始年月日.append(所定疾患施設療養費等データ.get所定疾患施設療養費開始年月日１())
                    .append(NewLine.CRLF.getNewLineString());
        }
        if (RString.isNullOrEmpty(new RString(所定疾患施設療養費等データ.get所定疾患施設療養費開始年月日２().toString()))) {
            所定疾患施設療養費開始年月日.append(NewLine.CRLF.getNewLineString());
        } else {
            所定疾患施設療養費開始年月日.append(所定疾患施設療養費等データ.get所定疾患施設療養費開始年月日２())
                    .append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(new RString(所定疾患施設療養費等データ.get所定疾患施設療養費開始年月日３().toString()))) {
            所定疾患施設療養費開始年月日.append(所定疾患施設療養費等データ.get所定疾患施設療養費開始年月日３());
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
        if (RString.isNullOrEmpty(new RString(所定疾患施設療養費等データ.get緊急時治療開始年月日１().toString()))) {
            緊急時治療開始年月日.append(NewLine.CRLF.getNewLineString());
        } else {
            緊急時治療開始年月日.append(所定疾患施設療養費等データ.get緊急時治療開始年月日１())
                    .append(NewLine.CRLF.getNewLineString());
        }
        if (RString.isNullOrEmpty(new RString(所定疾患施設療養費等データ.get緊急時治療開始年月日２().toString()))) {
            緊急時治療開始年月日.append(NewLine.CRLF.getNewLineString());
        } else {
            緊急時治療開始年月日.append(所定疾患施設療養費等データ.get緊急時治療開始年月日２())
                    .append(NewLine.CRLF.getNewLineString());
        }
        if (!RString.isNullOrEmpty(new RString(所定疾患施設療養費等データ.get緊急時治療開始年月日３().toString()))) {
            緊急時治療開始年月日.append(所定疾患施設療養費等データ.get緊急時治療開始年月日３());
        }
        return 緊急時治療開始年月日.toRString();
    }
}
