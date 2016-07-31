/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6020001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshojissekiichiran.IkenshoJissekiIchiran;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.ikenshojissekiichiran.IkenshoJissekiIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.ikenshojissekiichiran.IkenshoJissekiIchiranKey;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6020001.IkenshoSakuseiJissekiShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6020001.dgIkenshoSakuseiJisseki_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IshiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.ZaitakuShisetsuKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 意見書作成実績照会の画面処理Handlerクラスです。
 *
 * @reamsid_L DBE-1690-010 dongyabin
 */
public class IkenshoSakuseiJissekiShokaiHandler {

    private static final RString MARU = new RString("○");
    private static final RString 集計表を発行する = new RString("btnPulish");
    private static final RString CSVを出力する = new RString("btnShutsutyoku");
    private static final RString 条件に戻る = new RString("btnBackToKensaku");
    private final IkenshoSakuseiJissekiShokaiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public IkenshoSakuseiJissekiShokaiHandler(IkenshoSakuseiJissekiShokaiDiv div) {
        this.div = div;
    }

    /**
     * 条件をクリアする」ボタンを押します。
     */
    public void onClick_BtnKensakuClear() {
        div.getTxtIkenshoKinyubi().clearFromValue();
        div.getTxtIkenshoKinyubi().clearToValue();
        div.getTxtMaxKensu().setValue(new Decimal(DbBusinessConfig
                .get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getCcdHokensya().loadHokenshaList(GyomuBunrui.介護認定);
    }

    /**
     * 「検索する」ボタンを押します。
     *
     * @param ikenshoJissekiIchiranList 意見書作成実績照会
     */
    public void onClick_BtnKensaku(List<IkenshoJissekiIchiran> ikenshoJissekiIchiranList) {
        List<dgIkenshoSakuseiJisseki_Row> rowList = new ArrayList<>();
        for (IkenshoJissekiIchiran data : ikenshoJissekiIchiranList) {
            AccessLogger.log(AccessLogType.照会, toPersonalData(data.get申請書管理番号()));
            RString 在宅_新 = RString.EMPTY;
            RString 在宅_継 = RString.EMPTY;
            RString 施設_新 = RString.EMPTY;
            RString 施設_継 = RString.EMPTY;
            if (ZaitakuShisetsuKubun.在宅.getコード().equals(data.get在宅_施設区分())) {
                if (IkenshoIraiKubun.初回依頼.getコード().equals(data.get主治医意見書依頼区分())) {
                    在宅_新 = MARU;
                }
                if (IkenshoIraiKubun.再依頼.getコード().equals(data.get主治医意見書依頼区分())
                        || IkenshoIraiKubun.再意見書.getコード().equals(data.get主治医意見書依頼区分())) {
                    在宅_継 = MARU;
                }
            }
            if (ZaitakuShisetsuKubun.施設.getコード().equals(data.get在宅_施設区分())) {
                if (IkenshoIraiKubun.初回依頼.getコード().equals(data.get主治医意見書依頼区分())) {
                    施設_新 = MARU;
                }
                if (IkenshoIraiKubun.再依頼.getコード().equals(data.get主治医意見書依頼区分())
                        || IkenshoIraiKubun.再意見書.getコード().equals(data.get主治医意見書依頼区分())) {
                    施設_継 = MARU;
                }
            }
            dgIkenshoSakuseiJisseki_Row row = new dgIkenshoSakuseiJisseki_Row(data.get証記載保険者番号(),
                    data.get医療機関コード(),
                    data.get医療機関名称(),
                    data.get主治医氏名(),
                    data.get被保険者番号(),
                    data.get申請者氏名(),
                    dataFormat(data.get記入日()),
                    dataFormat(data.get入手日()),
                    在宅_新,
                    在宅_継,
                    施設_新,
                    施設_継,
                    IshiKubunCode.toValue(data.get医師区分コード()).get名称(),
                    data.get主治医コード(),
                    data.get申請書管理番号(),
                    data.get主治医意見書作成依頼履歴番号());
            rowList.add(row);
        }
        div.getDgIkenshoSakuseiJisseki().setDataSource(rowList);
    }

    private PersonalData toPersonalData(RString 申請書管理番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), 申請書管理番号);
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

    /**
     * 画面初期状態の設定です。
     */
    public void set初期状態() {
        CommonButtonHolder.setVisibleByCommonButtonFieldName(集計表を発行する, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(CSVを出力する, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(条件に戻る, false);
        div.getIkenshoSakuseiJisseki().setDisplayNone(true);
        div.getIkenshoKinyubi().setDisplayNone(false);
    }

    /**
     * 画面一覧状態の設定です。
     */
    public void set一覧状態() {
        CommonButtonHolder.setVisibleByCommonButtonFieldName(集計表を発行する, true);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(CSVを出力する, true);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(条件に戻る, true);
        div.getIkenshoSakuseiJisseki().setDisplayNone(false);
        div.getIkenshoKinyubi().setDisplayNone(true);
    }

    /**
     * バッチパラメータを作成します。
     *
     * @param 帳票出力区分 帳票出力区分
     * @return バッチパラメータ
     */
    public IkenshoJissekiIchiranBatchParameter createBatchParam(RString 帳票出力区分) {
        IkenshoJissekiIchiranBatchParameter param = new IkenshoJissekiIchiranBatchParameter();
        List<IkenshoJissekiIchiranKey> keyJoho = new ArrayList<>();
        for (dgIkenshoSakuseiJisseki_Row row : div.getDgIkenshoSakuseiJisseki().getDataSource()) {
            if (row.getSelected()) {
                IkenshoJissekiIchiranKey key = new IkenshoJissekiIchiranKey();
                key.setShujiiIryoKikanCode(row.getCode());
                key.setShujiiCode(row.getShujiiCode());
                key.setShinseishoKanriNo(row.getShinseishoKanriNo());
                key.setIkenshoIraiRirekiNo(Integer.parseInt(row.getIkenshoIraiRirekiNo().toString()));
                keyJoho.add(key);
            }
        }
        param.setKeyJoho(keyJoho);
        RString 意見書記入日FROM = RString.EMPTY;
        RString 意見書記入日TO = RString.EMPTY;
        if (div.getTxtIkenshoKinyubi().getFromValue() != null) {
            意見書記入日FROM = div.getTxtIkenshoKinyubi().getFromValue().toDateString();
        }
        if (div.getTxtIkenshoKinyubi().getToValue() != null) {
            意見書記入日TO = div.getTxtIkenshoKinyubi().getToValue().toDateString();
        }
        param.setIkenshoKinyubiFrom(意見書記入日FROM);
        param.setIkenshoKinyubiTo(意見書記入日TO);
        param.setHokensya(div.getCcdHokensya().getSelectedItem().get市町村コード().value());
        param.setSyohyoSyuturyoku(帳票出力区分);
        return param;
    }

    private RString dataFormat(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        RDate date_tmp = new RDate(date.toString());
        return date_tmp.wareki().toDateString();
    }
}
