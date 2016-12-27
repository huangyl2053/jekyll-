/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6050001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshohoshushokai.IkenshoHoshuShokaiBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601004.DBE601004_IkenshosakuseiHoshuParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.ikenshohoshushokaiichiran.IkenshoHoshuShokaiIchiranKey;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6050001.IkenshoSakuseiHoshuShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6050001.dgIkenshoSakuseiHoshu_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoIraiKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 意見書作成報酬照会の画面処理Handlerクラスです。
 *
 * @reamsid_L DBE-1930-010 chenxiangyu
 */
public class IkenshoSakuseiHoshuShokaiHandler {

    private static final RString MARU = new RString("○");
    private static final RString IRAIKUBUN_SHO = new RString("初");
    private static final RString IRAIKUBUN_SAI = new RString("再");
    private final IkenshoSakuseiHoshuShokaiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public IkenshoSakuseiHoshuShokaiHandler(IkenshoSakuseiHoshuShokaiDiv div) {
        this.div = div;
    }

    /**
     * 一覧結果を設定です。
     *
     * @param ikenshoHoshuShokaiBusinessList 意見書作成報酬照会
     * @param 総件数
     */
    public void set一覧結果(List<IkenshoHoshuShokaiBusiness> ikenshoHoshuShokaiBusinessList, int 総件数) {
        Decimal 在宅新規_合計 = Decimal.ZERO;
        Decimal 在宅継続_合計 = Decimal.ZERO;
        Decimal 施設新規_合計 = Decimal.ZERO;
        Decimal 施設継続_合計 = Decimal.ZERO;
        Decimal 作成料_合計 = Decimal.ZERO;
        Decimal 診療費_合計 = Decimal.ZERO;
        Decimal 報酬_合計 = Decimal.ZERO;
        Decimal count = Decimal.ZERO;
        List<dgIkenshoSakuseiHoshu_Row> row_list = new ArrayList<>();
        for (IkenshoHoshuShokaiBusiness date : ikenshoHoshuShokaiBusinessList) {
            AccessLogger.log(AccessLogType.照会, this.toPersonalData(date.get申請書管理番号()));
            dgIkenshoSakuseiHoshu_Row row = new dgIkenshoSakuseiHoshu_Row();
            count = count.add(Decimal.ONE);
            row.setNo(new RString(count.intValue()));
            row.setIryoKikanCode(date.get主治医医療機関コード());
            row.setIryoKikanMei(date.get医療機関名称());
            row.setCode(date.get主治医コード());
            row.setShujiiShimei(date.get主治医氏名());
            if (date.get主治医意見書作成依頼年月日() != null) {
                row.getIraibi().setValue(new RDate(date.get主治医意見書作成依頼年月日().toString()));
            }
            if (date.get主治医意見書記入年月日() != null) {
                row.getKinyubi().setValue(new RDate(date.get主治医意見書記入年月日().toString()));
            }
            if (date.get主治医意見書受領年月日() != null) {
                row.getNyushubi().setValue(new RDate(date.get主治医意見書受領年月日().toString()));
            }
            if (IkenshoIraiKubun.初回依頼.getコード().equals(date.get主治医意見書依頼区分())) {
                row.setIkenshoIraiKubun(IRAIKUBUN_SHO);
            } else {
                row.setIkenshoIraiKubun(IRAIKUBUN_SAI);
            }
            row.setHokenshaBango(date.get証記載保険者番号());
            row.setHihokenshaBango(date.get被保険者番号());
            row.setShinseishaShimei(date.get被保険者氏名());
            row.setZaitakuShin(date.get在宅_新());
            if (MARU.equals(date.get在宅_新())) {
                在宅新規_合計 = 在宅新規_合計.add(Decimal.ONE);
            }
            row.setZaitakuKe(date.get在宅_継());
            if (MARU.equals(date.get在宅_継())) {
                在宅継続_合計 = 在宅継続_合計.add(Decimal.ONE);
            }
            row.setShisetsuShin(date.get施設_新());
            if (MARU.equals(date.get施設_新())) {
                施設新規_合計 = 施設新規_合計.add(Decimal.ONE);
            }
            row.setShisetsuKe(date.get施設_継());
            if (MARU.equals(date.get施設_継())) {
                施設継続_合計 = 施設継続_合計.add(Decimal.ONE);
            }
            row.getSakuseiryo().setValue(new Decimal(date.get主治医意見書作成料()));
            作成料_合計 = 作成料_合計.add(date.get主治医意見書作成料());
            row.getShinryohito().setValue(new Decimal(date.get主治医意見書別途診療費()));
            診療費_合計 = 診療費_合計.add(date.get主治医意見書別途診療費());
            row.getGokei().setValue(new Decimal(date.get主治医意見書報酬()));
            報酬_合計 = 報酬_合計.add(date.get主治医意見書報酬());
            row.setShinseishoKanriNo(date.get申請書管理番号());
            row.setIkenshoIraiRirekiNo(new RString(date.get主治医意見書作成依頼履歴番号()));
            row_list.add(row);
        }
        div.getTxtZaitakuShinki().setValue(在宅新規_合計);
        div.getTxtZaitakuKeizoku().setValue(在宅継続_合計);
        div.getTxtShisetsuShinki().setValue(施設新規_合計);
        div.getTxtShisetsuKeizoku().setValue(施設継続_合計);
        div.getTxtSakuseiryo().setValue(作成料_合計);
        div.getTxtShinryohi().setValue(診療費_合計);
        div.getTxtHoshuGokei().setValue(報酬_合計);
        div.getDgIkenshoSakuseiHoshu().setDataSource(row_list);
        Decimal 最大表示件数 = div.getTxtMaxKensu().getValue();
        div.getDgIkenshoSakuseiHoshu().getGridSetting().setLimitRowCount(最大表示件数.intValue());
        div.getDgIkenshoSakuseiHoshu().getGridSetting().setSelectedRowCount(総件数);
    }

    /**
     * バッチパラメータの作成します。
     *
     * @param 帳票出力区分 帳票出力区分
     * @return 意見書作成報酬照会の合計額リスト_バッチフロークラスパラメータ
     */
    public DBE601004_IkenshosakuseiHoshuParameter createBatchParam(RString 帳票出力区分) {
        List<IkenshoHoshuShokaiIchiranKey> keyJohoList = new ArrayList<>();
        for (dgIkenshoSakuseiHoshu_Row row : div.getDgIkenshoSakuseiHoshu().getSelectedItems()) {
            IkenshoHoshuShokaiIchiranKey key = new IkenshoHoshuShokaiIchiranKey(
                    row.getIryoKikanCode(),
                    row.getCode(),
                    row.getShinseishoKanriNo(),
                    Integer.parseInt(row.getIkenshoIraiRirekiNo().toString()));
            keyJohoList.add(key);
        }
        FlexibleDate 作成依頼日開始 = FlexibleDate.EMPTY;
        FlexibleDate 作成依頼日終了 = FlexibleDate.EMPTY;
        if (div.getTxtSakuseiIraibi().getFromValue() != null) {
            作成依頼日開始 = new FlexibleDate(div.getTxtSakuseiIraibi().getFromValue().toDateString());
        }
        if (div.getTxtSakuseiIraibi().getToValue() != null) {
            作成依頼日終了 = new FlexibleDate(div.getTxtSakuseiIraibi().getToValue().toDateString());
        }
        RString 保険者 = div.getCcdHokensya().getSelectedItem().get市町村コード().value();
        return new DBE601004_IkenshosakuseiHoshuParameter(帳票出力区分, 作成依頼日開始, 作成依頼日終了, 保険者, keyJohoList);
    }

    private PersonalData toPersonalData(RString 申請書管理番号) {
        // TODO 介護認定用アクセスクラスへ変更
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), 申請書管理番号);
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

    /**
     * 作成依頼日をクリアします。
     */
    public void clear作成依頼日() {
        div.getTxtSakuseiIraibi().clearFromValue();
        div.getTxtSakuseiIraibi().clearToValue();
    }

    /**
     * 初期最大取得件数を設定です。
     */
    public void set初期最大取得件数() {
        div.getTxtMaxKensu().setValue(new Decimal(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(),
                SubGyomuCode.DBU介護統計報告).toString()));
        div.getTxtMaxKensu().setMaxValue(new Decimal(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(),
                SubGyomuCode.DBU介護統計報告).toString()));
    }
    
    public void resetシーケンス番号() {
        final RString sortKey = div.getDgIkenshoSakuseiHoshu().getSortOrder();
        List<dgIkenshoSakuseiHoshu_Row> rows = div.getDgIkenshoSakuseiHoshu().getDataSource();
        List<dgIkenshoSakuseiHoshu_Row> sortedRows = new ArrayList<>(rows);
        if (!RString.isNullOrEmpty(sortKey)) {
            // 指定の列で並び替え
            Collections.sort(sortedRows, new Comparator<dgIkenshoSakuseiHoshu_Row>() {
                @Override
                public int compare(dgIkenshoSakuseiHoshu_Row o1, dgIkenshoSakuseiHoshu_Row o2) {
                    int result;
                    switch(sortKey.toString()) {
                        case "iryoKikanCode":
                            result = o1.getIryoKikanCode().compareTo(o2.getIryoKikanCode());
                            break;
                        case "iryoKikanMei":
                            result = o1.getIryoKikanMei().compareTo(o2.getIryoKikanMei());
                            break;
                        case "code":
                            result = o1.getCode().compareTo(o2.getCode());
                            break;
                        case "shujiiShimei":
                            result = o1.getShujiiShimei().compareTo(o2.getShujiiShimei());
                            break;
                        case "iraibi":
                            result = o1.getIraibi().getValue().compareTo(o2.getIraibi().getValue());
                            break;
                        case "kinyubi":
                            result = o1.getKinyubi().getValue().compareTo(o2.getKinyubi().getValue());
                            break;
                        case "nyushubi":
                            result = o1.getNyushubi().getValue().compareTo(o2.getNyushubi().getValue());
                            break;
                        case "ikenshoIraiKubun":
                            result = o1.getIkenshoIraiKubun().compareTo(o2.getIkenshoIraiKubun());
                            break;
                        case "hokenshaBango":
                            result = o1.getHokenshaBango().compareTo(o2.getHokenshaBango());
                            break;
                        case "hihokenshaBango":
                            result = o1.getHihokenshaBango().compareTo(o2.getHihokenshaBango());
                            break;
                        case "shinseishaShimei":
                            result = o1.getShinseishaShimei().compareTo(o2.getShinseishaShimei());
                            break;
                        case "zaitakuShin":
                            result = o1.getZaitakuShin().compareTo(o2.getZaitakuShin());
                            break;
                        case "zaitakuKe":
                            result = o1.getZaitakuKe().compareTo(o2.getZaitakuKe());
                            break;
                        case "shisetsuShin":
                            result = o1.getShisetsuShin().compareTo(o2.getShisetsuShin());
                            break;
                        case "shisetsuKe":
                            result = o1.getShisetsuKe().compareTo(o2.getShisetsuKe());
                            break;
                        case "sakuseiryo":
                            result = compareDecimal(o1.getSakuseiryo().getValue(), o2.getSakuseiryo().getValue());
                            break;
                        case "shinryohito":
                            result = compareDecimal(o1.getShinryohito().getValue(), o2.getShinryohito().getValue());
                            break;
                        case "gokei":
                            result = compareDecimal(o1.getGokei().getValue(), o2.getGokei().getValue());
                            break;
                        case "shinseishoKanriNo":
                            result = o1.getShinseishoKanriNo().compareTo(o2.getShinseishoKanriNo());
                            break;
                        case "ikenshoIraiRirekiNo":
                            result = o1.getIkenshoIraiRirekiNo().compareTo(o2.getIkenshoIraiRirekiNo());
                            break;
                        default:
                            result = 0;
                            break;
                    }
                    
                    return result;
                }
            });
        } else {
            // デフォルト順で並び替え（主治医医療機関コード、主治医コード、申請書管理番号、主治医意見書作成依頼履歴番号）
            Collections.sort(sortedRows, new Comparator<dgIkenshoSakuseiHoshu_Row>() {
                @Override
                public int compare(dgIkenshoSakuseiHoshu_Row o1, dgIkenshoSakuseiHoshu_Row o2) {
                    int result;
                    
                    // 主治医医療機関コード
                    result = o1.getIryoKikanCode().compareTo(o2.getIryoKikanCode());
                    if (result != 0) {
                        return result;
                    }
                    
                    // 主治医コード
                    result = o1.getCode().compareTo(o2.getCode());
                    if (result != 0) {
                        return result;
                    }
                    
                    // 申請書管理番号
                    result = o1.getShinseishoKanriNo().compareTo(o2.getShinseishoKanriNo());
                    if (result != 0) {
                        return result;
                    }
                    
                    // 主治医意見書作成依頼履歴番号
                    result = o1.getIkenshoIraiRirekiNo().compareTo(o2.getIkenshoIraiRirekiNo());
                    return result;
                }
            });
        }
        
        // シーケンス番号を採番
        Decimal count = Decimal.ZERO;
        for (dgIkenshoSakuseiHoshu_Row row : sortedRows) {
            count = count.add(Decimal.ONE);
            row.setNo(new RString(count.intValue()));
        }
    }
    
    private static int compareDecimal(Decimal decimal1, Decimal decimal2) {
        int result;
        if ((decimal1 != null)
                && (decimal2 != null)) {
            result = decimal1.compareTo(decimal2);
        } else if (decimal1 == null) {
            result = -1;
        } else {
            result = 1;
        }
        return result;
    }
}
