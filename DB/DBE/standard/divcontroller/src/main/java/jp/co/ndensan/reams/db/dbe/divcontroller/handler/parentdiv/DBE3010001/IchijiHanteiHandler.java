/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ichijipanteisyori.IChiJiPanTeiSyoRiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJohoBuilder;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.itizihanteishori.ItziHanteiShoriBatchParamter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010001.IchijiHanteiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010001.dgIchijiHanteiTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.JotaiAnteiseiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.SuiteiKyufuKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 画面設計_DBE3010001_一次判定処理クラスです。
 *
 * @reamsid_L DBE-1470-010 houtianpeng
 */
public class IchijiHanteiHandler {

    private final IchijiHanteiDiv div;
    private static final Code 認定ｿﾌﾄ99 = new Code(new RString("99A"));
    private static final Code 認定ｿﾌﾄ2002 = new Code(new RString("02A"));
    private static final Code 認定ｿﾌﾄ2006 = new Code(new RString("06A"));
    private static final Code 認定ｿﾌﾄ2009_A = new Code(new RString("09A"));
    private static final Code 認定ｿﾌﾄ2009_B = new Code(new RString("09B"));
    private static final RString データ出力を実行する = new RString("btnSyutsuryoku");

    /**
     * コンストラクタです。
     *
     * @param div IchijiHanteiDiv
     */
    public IchijiHanteiHandler(IchijiHanteiDiv div) {
        this.div = div;
    }

    /**
     * 認定調査データ取込の設定します。
     *
     */
    public void initializtion() {
        RString 最大表示件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 最大上限 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getIchijiHanteiKensakuJoken().getTxtMaxCount().setValue(new Decimal(最大表示件数.toString()));
        div.getIchijiHanteiKensakuJoken().getTxtMaxCount().setMaxValue(new Decimal(最大上限.toString()));
    }

    /**
     * 条件をクリアする。
     *
     */
    public void clear() {
        div.getIchijiHanteiKensakuJoken().getTxtShinseiDateRange().clearFromValue();
        div.getIchijiHanteiKensakuJoken().getTxtShinseiDateRange().clearToValue();
        div.getIchijiHanteiKensakuJoken().getTxtMaxCount().clearValue();
    }

    /**
     * バッチパラメータの作成。
     *
     * @param バッチ出力区分 RString
     * @return ItziHanteiShoriBatchParamter
     */
    public ItziHanteiShoriBatchParamter バッチパラメータの作成(RString バッチ出力区分) {

        ItziHanteiShoriBatchParamter parameter = new ItziHanteiShoriBatchParamter();
        List<dgIchijiHanteiTaishoshaIchiran_Row> rowList = div.getIchijiHanteiShoriTaishoshaIchiran().
                getDgIchijiHanteiTaishoshaIchiran().getSelectedItems();
        List<RString> shinseishoKanriNo = new ArrayList<>();
        for (dgIchijiHanteiTaishoshaIchiran_Row row : rowList) {

            shinseishoKanriNo.add(row.getShinseishoKanriNo());
        }
        parameter.setShinseishoKanriNoList(shinseishoKanriNo);
        parameter.setBattishuturyokukubun(バッチ出力区分);
        return parameter;
    }

    /**
     * 要介護認定一次判定結果情報の編集。
     *
     * @param row 対象者一覧
     * @param entity 要介護認定一次判定結果情報
     * @param flg 登録、更新判定フラグ
     * @return 要介護認定一次判定結果情報ビルダー
     */
    public IchijiHanteiKekkaJohoBuilder 要介護認定一次判定結果情報の編集(dgIchijiHanteiTaishoshaIchiran_Row row,
            IchijiHanteiKekkaJoho entity, RString flg) {

        IchijiHanteiKekkaJohoBuilder builder = entity.createBuilderForEdit();
        if (flg.isEmpty()) {
            builder.set仮一次判定区分(true);
        }
        builder.set要介護認定一次判定年月日(row.getIchijiHanteibi().getValue());
        builder.set要介護認定一次判定結果コード(一次判定結果のコードを取得する(row.
                getKoroshoIfShikibetsuCode(), row.getIchijiHanteiKekka()));
        builder.set要介護認定一次判定結果コード_認知症加算(一次判定結果のコードを取得する(row.
                getKoroshoIfShikibetsuCode(), row.getIchijiHanteiKekkaNinchishoKasanCode()));
        builder.set要介護認定等基準時間(Integer.valueOf(row.getKijunJikan().toString()));
        builder.set要介護認定等基準時間_食事(Integer.valueOf(row.getKijunJikanShokuji().toString()));
        builder.set要介護認定等基準時間_排泄(Integer.valueOf(row.getKijunJikanHaisetsu().toString()));
        builder.set要介護認定等基準時間_移動(Integer.valueOf(row.getKijunJikanIdo().toString()));
        builder.set要介護認定等基準時間_清潔保持(Integer.valueOf(row.getKijunJikanSeiketsuHoji().toString()));
        builder.set要介護認定等基準時間_間接ケア(Integer.valueOf(row.getKijunJikanKansetsuCare().toString()));
        builder.set要介護認定等基準時間_BPSD関連(Integer.valueOf(row.getKijunJikanBPSDKanren().toString()));
        builder.set要介護認定等基準時間_機能訓練(Integer.valueOf(row.getKijunJikanKinoKunren().toString()));
        builder.set要介護認定等基準時間_医療関連(Integer.valueOf(row.getKijunJikanIryoKanren().toString()));
        builder.set要介護認定等基準時間_認知症加算(Integer.valueOf(row.getKijunJikanNinchishoKasan().toString()));
        builder.set中間評価項目得点第1群(Integer.valueOf(row.getChukanHyokaKomoku1gun().toString()));
        builder.set中間評価項目得点第2群(Integer.valueOf(row.getChukanHyokaKomoku2gun().toString()));
        builder.set中間評価項目得点第3群(Integer.valueOf(row.getChukanHyokaKomoku3gun().toString()));
        builder.set中間評価項目得点第4群(Integer.valueOf(row.getChukanHyokaKomoku4gun().toString()));
        builder.set中間評価項目得点第5群(Integer.valueOf(row.getChukanHyokaKomoku5gun().toString()));

        if (!RString.isNullOrEmpty(row.getKeikokuCode())) {
            builder.set要介護認定一次判定警告コード(row.getKeikokuCode());
        }
        if (!RString.isNullOrEmpty(row.getJotaiAnteiseiCode())) {
            builder.set要介護認定状態の安定性コード(new Code(JotaiAnteiseiCode.
                    valueOf(row.getJotaiAnteiseiCode().toString()).getコード()));
        }
        if (!RString.isNullOrEmpty(row.getNinchishoJiritsudoIIijoNoGaizensei())) {
            builder.set認知症自立度Ⅱ以上の蓋然性(new Decimal(row.getNinchishoJiritsudoIIijoNoGaizensei().toString()));
        }
        if (!RString.isNullOrEmpty(row.getSuiteiKyufuKubunCode())) {
            builder.set認知機能及び状態安定性から推定される給付区分コード(new Code(SuiteiKyufuKubunCode.
                    valueOf(row.getSuiteiKyufuKubunCode().toString()).getコード()));
        }

        return builder;
    }

    /**
     * 対象者一覧の編集。
     *
     * @param 一次判定対象者一覧List List<IChiJiPanTeiSyoRiBusiness>
     * @param personalData PersonalData
     */
    public void 対象者一覧の編集(List<IChiJiPanTeiSyoRiBusiness> 一次判定対象者一覧List, PersonalData personalData) {

        List<dgIchijiHanteiTaishoshaIchiran_Row> rowList = new ArrayList<>();
        for (IChiJiPanTeiSyoRiBusiness business : 一次判定対象者一覧List) {

            dgIchijiHanteiTaishoshaIchiran_Row row = new dgIchijiHanteiTaishoshaIchiran_Row();
            row.setColumnState(RString.EMPTY);
            row.setHokensha(business.get市町村名称());
            row.setHihokenNo(business.get被保険者番号());
            row.setHihokenshaName(business.get被保険者氏名().value());
            row.getShinseibi().setValue(business.get認定申請年月日());
            row.setShinseiKbnShin(NinteiShinseiShinseijiKubunCode.
                    toValue(business.get認定申請区分_申請時コード().value()).get名称());
            row.getIchijiHanteibi().setValue(business.get要介護認定一次判定年月日());
            row.setIchijiHanteiKekka(一次判定結果の名称を取得する(new Code(business.
                    get厚労省IF識別コード()), business.get要介護認定一次判定結果コード()));
            row.setIchijiHanteiKekkaNinchishoKasanCode(一次判定結果の名称を取得する(new Code(business.
                    get厚労省IF識別コード()), business.get要介護認定一次判定結果コード_認知症加算()));
            row.setKeikokuCode(business.get要介護認定一次判定警告コード());
            row.getChosaJissibi().setValue(business.get認定調査実施年月日());
            row.getIkenshoJuryobi().setValue(business.get主治医意見書受領年月日());
            row.setKijunJikan(new RString(String.valueOf(business.get要介護認定等基準時間())));
            row.setKijunJikanShokuji(new RString(String.valueOf(business.get要介護認定等基準時間_食事())));
            row.setKijunJikanHaisetsu(new RString(String.valueOf(business.get要介護認定等基準時間_排泄())));
            row.setKijunJikanIdo(new RString(String.valueOf(business.get要介護認定等基準時間_移動())));
            row.setKijunJikanSeiketsuHoji(new RString(String.valueOf(business.get要介護認定等基準時間_清潔保持())));
            row.setKijunJikanKansetsuCare(new RString(String.valueOf(business.get要介護認定等基準時間_間接ケア())));
            row.setKijunJikanBPSDKanren(new RString(String.valueOf(business.get要介護認定等基準時間_BPSD関連())));
            row.setKijunJikanKinoKunren(new RString(String.valueOf(business.get要介護認定等基準時間_機能訓練())));
            row.setKijunJikanIryoKanren(new RString(String.valueOf(business.get要介護認定等基準時間_医療関連())));
            row.setKijunJikanNinchishoKasan(new RString(String.valueOf(business.get要介護認定等基準時間_認知症加算())));
            row.setChukanHyokaKomoku1gun(new RString(String.valueOf(business.get中間評価項目得点第1群())));
            row.setChukanHyokaKomoku2gun(new RString(String.valueOf(business.get中間評価項目得点第2群())));
            row.setChukanHyokaKomoku3gun(new RString(String.valueOf(business.get中間評価項目得点第3群())));
            row.setChukanHyokaKomoku4gun(new RString(String.valueOf(business.get中間評価項目得点第4群())));
            row.setChukanHyokaKomoku5gun(new RString(String.valueOf(business.get中間評価項目得点第5群())));
            if (business.get要介護認定状態の安定性コード() != null && !business.get要介護認定状態の安定性コード().isEmpty()) {
                row.setJotaiAnteiseiCode(JotaiAnteiseiCode.toValue(business.get要介護認定状態の安定性コード().value()).get名称());
            }
            if (business.get認知症自立度Ⅱ以上の蓋然性() != null) {
                row.setNinchishoJiritsudoIIijoNoGaizensei(new RString(String.valueOf(business.get認知症自立度Ⅱ以上の蓋然性())));
            }
            if (business.get推定される給付区分コード() != null && !business.get推定される給付区分コード().isEmpty()) {
                row.setSuiteiKyufuKubunCode(SuiteiKyufuKubunCode.toValue(business.get推定される給付区分コード().value()).get名称());
            }
            row.setShinseishoKanriNo(business.get申請書管理番号().value());
            row.setKoroshoIfShikibetsuCode(business.get厚労省IF識別コード());
            personalData.addExpandedInfo(new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                    business.get申請書管理番号().value()));
            rowList.add(row);
        }
        if (一次判定対象者一覧List.isEmpty()) {

            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(データ出力を実行する, true);
        }
        div.getIchijiHanteiShoriTaishoshaIchiran().getDgIchijiHanteiTaishoshaIchiran().setDataSource(rowList);
    }

    /**
     * 対象者一覧の「⇒」の編集。
     *
     * @param row 対象者一覧
     * @param index 選択のインデックス
     * @param business 要介護認定一次判定結果情報
     */
    public void 対象者一覧更新の編集(dgIchijiHanteiTaishoshaIchiran_Row row, int index, IchijiHanteiKekkaJoho business) {

        row.setColumnState(new RString("更新"));
        if (business.get要介護認定一次判定年月日() != null) {
            row.getIchijiHanteibi().setValue(business.get要介護認定一次判定年月日());
        }
        if (business.get要介護認定一次判定結果コード() != null) {
            row.setIchijiHanteiKekka(IchijiHanteiKekkaCode09.toValue(business.
                    get要介護認定一次判定結果コード().value()).get名称());
        }
        if (business.get要介護認定一次判定結果コード_認知症加算() != null) {
            row.setIchijiHanteiKekkaNinchishoKasanCode(IchijiHanteiKekkaCode09.
                    toValue(business.get要介護認定一次判定結果コード_認知症加算().value()).get名称());
        }
        if (business.get要介護認定一次判定警告コード() != null) {
            row.setKeikokuCode(business.get要介護認定一次判定警告コード());
        }
        row.setKijunJikan(new RString(String.valueOf(business.get要介護認定等基準時間())));
        row.setKijunJikanShokuji(new RString(String.valueOf(business.get要介護認定等基準時間_食事())));
        row.setKijunJikanHaisetsu(new RString(String.valueOf(business.get要介護認定等基準時間_排泄())));
        row.setKijunJikanIdo(new RString(String.valueOf(business.get要介護認定等基準時間_移動())));
        row.setKijunJikanSeiketsuHoji(new RString(String.valueOf(business.get要介護認定等基準時間_清潔保持())));
        row.setKijunJikanKansetsuCare(new RString(String.valueOf(business.get要介護認定等基準時間_間接ケア())));
        row.setKijunJikanBPSDKanren(new RString(String.valueOf(business.get要介護認定等基準時間_BPSD関連())));
        row.setKijunJikanKinoKunren(new RString(String.valueOf(business.get要介護認定等基準時間_機能訓練())));
        row.setKijunJikanIryoKanren(new RString(String.valueOf(business.get要介護認定等基準時間_医療関連())));
        row.setKijunJikanNinchishoKasan(new RString(String.valueOf(business.get要介護認定等基準時間_認知症加算())));
        row.setChukanHyokaKomoku1gun(new RString(String.valueOf(business.get中間評価項目得点第1群())));
        row.setChukanHyokaKomoku2gun(new RString(String.valueOf(business.get中間評価項目得点第2群())));
        row.setChukanHyokaKomoku3gun(new RString(String.valueOf(business.get中間評価項目得点第3群())));
        row.setChukanHyokaKomoku4gun(new RString(String.valueOf(business.get中間評価項目得点第4群())));
        row.setChukanHyokaKomoku5gun(new RString(String.valueOf(business.get中間評価項目得点第5群())));
        if (business.get要介護認定状態の安定性コード() != null && !business.get要介護認定状態の安定性コード().isEmpty()) {
            row.setJotaiAnteiseiCode(JotaiAnteiseiCode.toValue(business.get要介護認定状態の安定性コード().value()).get名称());
        }
        if (business.get認知症自立度Ⅱ以上の蓋然性() != null) {
            row.setNinchishoJiritsudoIIijoNoGaizensei(new RString(String.valueOf(business.get認知症自立度Ⅱ以上の蓋然性())));
        }
        if (business.get認知機能及び状態安定性から推定される給付区分コード() != null) {
            row.setSuiteiKyufuKubunCode(SuiteiKyufuKubunCode.toValue(business.get認知機能及び状態安定性から推定される給付区分コード().value()).get名称());
        }
        div.getIchijiHanteiShoriTaishoshaIchiran().getDgIchijiHanteiTaishoshaIchiran().getDataSource().set(index, row);
    }

    private RString 一次判定結果の名称を取得する(Code 厚労省IF識別コード, Code 一次判定結果コード) {

        if (一次判定結果コード != null && !一次判定結果コード.isEmpty()) {
            if (認定ｿﾌﾄ99.equals(厚労省IF識別コード)) {
                return IchijiHanteiKekkaCode99.toValue(一次判定結果コード.getKey()).get名称();
            } else if (認定ｿﾌﾄ2002.equals(厚労省IF識別コード)) {
                return IchijiHanteiKekkaCode02.toValue(一次判定結果コード.getKey()).get名称();
            } else if (認定ｿﾌﾄ2006.equals(厚労省IF識別コード)) {
                return IchijiHanteiKekkaCode06.toValue(一次判定結果コード.getKey()).get名称();
            } else if (認定ｿﾌﾄ2009_A.equals(厚労省IF識別コード)
                    || 認定ｿﾌﾄ2009_B.equals(厚労省IF識別コード)) {
                return IchijiHanteiKekkaCode09.toValue(一次判定結果コード.getKey()).get名称();
            }
        }
        return RString.EMPTY;
    }

    private Code 一次判定結果のコードを取得する(RString 厚労省IF識別コード, RString 一次判定結果名称) {

        if (!RString.isNullOrEmpty(一次判定結果名称)) {

            if (認定ｿﾌﾄ99.value().equals(厚労省IF識別コード)) {
                return new Code(IchijiHanteiKekkaCode99.valueOf(要介護認定一次判定結果コード99の名称(一次判定結果名称)).getコード());
            } else if (認定ｿﾌﾄ2002.value().equals(厚労省IF識別コード)) {
                return new Code(IchijiHanteiKekkaCode02.valueOf(要介護認定一次判定結果コード02の名称(一次判定結果名称)).getコード());
            } else if (認定ｿﾌﾄ2006.value().equals(厚労省IF識別コード)) {
                return new Code(IchijiHanteiKekkaCode06.valueOf(要介護認定一次判定結果コード06の名称(一次判定結果名称)).getコード());
            } else if (認定ｿﾌﾄ2009_A.value().equals(厚労省IF識別コード)
                    || 認定ｿﾌﾄ2009_B.value().equals(厚労省IF識別コード)) {
                return new Code(IchijiHanteiKekkaCode09.valueOf(要介護認定一次判定結果コード09の名称(一次判定結果名称)).getコード());
            }
        }
        return Code.EMPTY;
    }

    private String 要介護認定一次判定結果コード99の名称(RString 一次判定結果名称) {
        if (IchijiHanteiKekkaCode99.みなし要支援.get名称().equals(一次判定結果名称)) {

            return IchijiHanteiKekkaCode99.みなし要支援.toString();
        } else if (IchijiHanteiKekkaCode99.みなし非該当.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode99.みなし非該当.toString();
        } else if (IchijiHanteiKekkaCode99.経過的要介護.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode99.経過的要介護.toString();
        } else if (IchijiHanteiKekkaCode99.要介護1.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode99.要介護1.toString();
        } else if (IchijiHanteiKekkaCode99.要介護2.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode99.要介護2.toString();
        } else if (IchijiHanteiKekkaCode99.要介護3.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode99.要介護3.toString();
        } else if (IchijiHanteiKekkaCode99.要介護4.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode99.要介護4.toString();
        } else if (IchijiHanteiKekkaCode99.要介護5.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode99.要介護5.toString();
        } else if (IchijiHanteiKekkaCode99.非該当.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode99.非該当.toString();
        }
        return RString.EMPTY.toString();
    }

    private String 要介護認定一次判定結果コード02の名称(RString 一次判定結果名称) {
        if (IchijiHanteiKekkaCode02.要介護1.get名称().equals(一次判定結果名称)) {

            return IchijiHanteiKekkaCode02.要介護1.toString();
        } else if (IchijiHanteiKekkaCode02.要介護2.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode02.要介護2.toString();
        } else if (IchijiHanteiKekkaCode02.要介護3.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode02.要介護3.toString();
        } else if (IchijiHanteiKekkaCode02.要介護4.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode02.要介護4.toString();
        } else if (IchijiHanteiKekkaCode02.要介護5.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode02.要介護5.toString();
        } else if (IchijiHanteiKekkaCode02.要支援.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode02.要支援.toString();
        } else if (IchijiHanteiKekkaCode02.非該当.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode02.非該当.toString();
        }
        return RString.EMPTY.toString();
    }

    private String 要介護認定一次判定結果コード06の名称(RString 一次判定結果名称) {
        if (IchijiHanteiKekkaCode06.要介護1.get名称().equals(一次判定結果名称)) {

            return IchijiHanteiKekkaCode06.要介護1.toString();
        } else if (IchijiHanteiKekkaCode06.要介護2.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode06.要介護2.toString();
        } else if (IchijiHanteiKekkaCode06.要介護3.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode06.要介護3.toString();
        } else if (IchijiHanteiKekkaCode06.要介護4.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode06.要介護4.toString();
        } else if (IchijiHanteiKekkaCode06.要介護5.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode06.要介護5.toString();
        } else if (IchijiHanteiKekkaCode06.経過的要介護.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode06.経過的要介護.toString();
        } else if (IchijiHanteiKekkaCode06.非該当.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode06.非該当.toString();
        }
        return RString.EMPTY.toString();
    }

    private String 要介護認定一次判定結果コード09の名称(RString 一次判定結果名称) {
        if (IchijiHanteiKekkaCode09.要介護1.get名称().equals(一次判定結果名称)) {

            return IchijiHanteiKekkaCode09.要介護1.toString();
        } else if (IchijiHanteiKekkaCode09.要介護2.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode09.要介護2.toString();
        } else if (IchijiHanteiKekkaCode09.要介護3.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode09.要介護3.toString();
        } else if (IchijiHanteiKekkaCode09.要介護4.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode09.要介護4.toString();
        } else if (IchijiHanteiKekkaCode09.要介護5.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode09.要介護5.toString();
        } else if (IchijiHanteiKekkaCode09.送付済.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode09.送付済.toString();
        } else if (IchijiHanteiKekkaCode09.非該当.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode09.非該当.toString();
        } else if (IchijiHanteiKekkaCode09.要支援2.get名称().equals(一次判定結果名称)) {
            return IchijiHanteiKekkaCode09.要支援2.toString();
        }
        return RString.EMPTY.toString();
    }
}
