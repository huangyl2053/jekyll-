/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD511002.DBD511002_KoshinOshiraseTsuchiParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5010001.KoshinTaishoDiv;
import jp.co.ndensan.reams.db.dbd.service.core.dbd5010001.KoshinKanriManager;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;

/**
 * 画面設計_DBD5010001_完了処理・更新管理のKoshinTaishoHandlerです。
 *
 * @reamsid_L DBD-2030-010 x_youyj
 */
public class KoshinTaishoHandler {

    /**
     * 調査データ（モバイル用）の作成を行う
     *
     * @param div KoshinTaishoDiv
     * @return SharedFileEntryDescriptor
     */
    public SharedFileEntryDescriptor csvSyuShayou(KoshinTaishoDiv div) {
        List<RString> 申請書管理番号 = new ArrayList<>();
        for (dgNinteiTaskList_Row row : div.getCcdKoshinTaisho().getCheckbox()) {
            if (row.getShinseishoKanriNo() != null) {
                申請書管理番号.add(row.getShinseishoKanriNo());
            }
        }
        return KoshinKanriManager.createInstance().get調査データの取得(申請書管理番号);
    }

    /**
     * 認定調査依頼情報のモバイルデータ出力済フラグを出力済みで更新する。
     *
     * @param div KoshinTaishoDiv
     */
    public void koushiDb(KoshinTaishoDiv div) {
        for (dgNinteiTaskList_Row row : div.getCcdKoshinTaisho().getCheckbox()) {
            KoshinKanriManager.createInstance().get認定調査依頼情報の取得(row.getShinseishoKanriNo());
        }
    }

    /**
     * バッチパラメータを設定、バッチ起動を起動します。
     *
     * @param div KoshinTaishoDiv
     * @param parameter DBD511002_KoshinOshiraseTsuchiParameter
     */
    public void onCilck_btnBatchRegister(DBD511002_KoshinOshiraseTsuchiParameter parameter, KoshinTaishoDiv div) {
        List<RString> 申請書管理番号リスト = new ArrayList<>();
        for (dgNinteiTaskList_Row row : div.getCcdKoshinTaisho().getCheckbox()) {
            申請書管理番号リスト.add(row.getShinseishoKanriNo());
        }
        RString 出力対象区分 = new RString("");
        if (div.getChkOutPutSelect().getSelectedKeys().size() == 1) {
            if (new RString("0").equals(div.getChkOutPutSelect().getSelectedKeys().get(0))) {
                出力対象区分 = new RString("0");
            } else {
                出力対象区分 = new RString("1");
            }
        } else if (div.getChkOutPutSelect().getSelectedKeys().size() == 2) {
            出力対象区分 = new RString("2");
        }
        if (null != div.getTxtKikan().getFromValue()) {
            FlexibleDate 抽出対象期間_開始 = new FlexibleDate(div.getTxtKikan().getFromValue().toDateString());
            parameter.set抽出対象期間_開始(抽出対象期間_開始);
        }
        if (null != div.getTxtKikan().getToValue()) {
            FlexibleDate 抽出対象期間_終了 = new FlexibleDate(div.getTxtKikan().getToValue().toDateString());
            parameter.set抽出対象期間_終了(抽出対象期間_終了);
        }
        FlexibleDate 通知書発行日 = div.getTxtHakobi().getValue();
        if (div.getCcdChohyoShutsuryokuJun().get出力順ID() != null) {
            parameter.set出力順(new RString(div.getCcdChohyoShutsuryokuJun().get出力順ID().toString()));
        }
        parameter.set出力対象区分(出力対象区分);
        parameter.set申請書管理番号リスト(申請書管理番号リスト);
        parameter.set通知書発行日(通知書発行日);
    }

    /**
     * 要介護認定申請情報の取得する。
     *
     * @param div KoshinTaishoDiv
     */
    public void youKihoKoushiDb(KoshinTaishoDiv div) {
        for (dgNinteiTaskList_Row row : div.getCcdKoshinTaisho().getCheckbox()) {
            KoshinKanriManager.createInstance().get要介護認定申請情報の取得(row.getShinseishoKanriNo());
            KoshinKanriManager.createInstance().insert受給者台帳情報(row.getShinseishoKanriNo());
        }
    }

    /**
     * アクセスログ情報を作成する。
     *
     * @param div KoshinTaishoDiv
     * @return List<PersonalData>
     */
    public List<PersonalData> アクセスログ情報(KoshinTaishoDiv div) {
        List<PersonalData> personalDataList = new ArrayList<>();
        PersonalData personalData;
        for (dgNinteiTaskList_Row row : div.getCcdKoshinTaisho().getDataSource()) {
            personalData = PersonalData.of(ShikibetsuCode.EMPTY,
                    new ExpandedInformation(
                            new Code("0001"),
                            new RString("申請書管理番号"),
                            row.getShinseishoKanriNo()));
            personalDataList.add(personalData);
            personalData = PersonalData.of(ShikibetsuCode.EMPTY,
                    new ExpandedInformation(
                            new Code("0002"),
                            new RString("証記載保険者番号"),
                            row.getKaisaiNumber()));
            personalDataList.add(personalData);
            personalData = PersonalData.of(ShikibetsuCode.EMPTY,
                    new ExpandedInformation(
                            new Code("0003"),
                            new RString("被保険者番号"),
                            row.getHihoNumber()));
            personalDataList.add(personalData);
        }
        return personalDataList;
    }

}
