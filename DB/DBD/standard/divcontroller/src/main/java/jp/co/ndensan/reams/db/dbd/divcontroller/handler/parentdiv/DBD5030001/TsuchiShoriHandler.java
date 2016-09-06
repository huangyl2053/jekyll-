/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5030001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.TsuchishoHakkoJoho;
import jp.co.ndensan.reams.db.dbd.business.core.dbd5030001.TsuchiShoriBusiness;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5030001.dgtsuchishohakko_Row;
import jp.co.ndensan.reams.db.dbd.service.core.dbd5030001.TsuchiShoriManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;

/**
 * 完了処理・通知書発行画面のHandlerです。
 *
 * @reamsid_L DBD-2040-010 chenxin
 */
public class TsuchiShoriHandler {

    /**
     * 画面初期化です。
     *
     * @return List<dgtsuchishohakko_Row>
     */
    public List<dgtsuchishohakko_Row> onLoad() {
        List<dgtsuchishohakko_Row> 画面情報一覧 = new ArrayList<>();
        TsuchiShoriManager manager = TsuchiShoriManager.createInstance();
        List<TsuchiShoriBusiness> 初期化情報 = manager.初期化情報取得();
        for (TsuchiShoriBusiness tsuchiShoriBusiness : 初期化情報) {
            dgtsuchishohakko_Row 画面情報 = new dgtsuchishohakko_Row();
            画面情報.setHokensha(tsuchiShoriBusiness.get市町村名称());
            画面情報.setHihoNumber(tsuchiShoriBusiness.get被保険者番号());
            画面情報.setHihoShimei(tsuchiShoriBusiness.get被保険者氏名());
            画面情報.setNinteiShinseiDay(tsuchiShoriBusiness.get認定申請年月日());
            画面情報.setShinseiKubunShinseiji(tsuchiShoriBusiness.get認定申請区分申請時コード());
            画面情報.setShinseiKubunHorei(tsuchiShoriBusiness.get認定申請区分法令コード());
            画面情報.setTsuchiKanryobi(tsuchiShoriBusiness.get通知完了年月日());
            画面情報.setNinteitsuchishobi(tsuchiShoriBusiness.get認定結果通知書発行年月日());
            画面情報.setKubunhenkotsuchishobi(tsuchiShoriBusiness.get区分変更通知書発行年月日());
            画面情報.setServicehenkotsuchishobi(tsuchiShoriBusiness.getサービス変更通知書発行年月日());
            画面情報.setNinteikyakatsuchishobi(tsuchiShoriBusiness.get認定却下通知書発行年月日());
            画面情報.setNinteitorikeshitsuchishobi(tsuchiShoriBusiness.get認定取消通知書発行年月日());
            画面情報.setShinseishoKanriNo(tsuchiShoriBusiness.get申請書管理番号());
            画面情報.setShoKisaiHokenshaNo(tsuchiShoriBusiness.get証記載保険者番号());
            画面情報一覧.add(画面情報);
        }
        return 画面情報一覧;
    }

    /**
     * アクセスログ情報を作成する。
     *
     * @param 情報リスト List<dgtsuchishohakko_Row>
     * @return List<PersonalData>
     */
    public List<PersonalData> アクセスログ情報(List<dgtsuchishohakko_Row> 情報リスト) {
        List<PersonalData> personalDataList = new ArrayList<>();
        PersonalData personalData;
        for (dgtsuchishohakko_Row row : 情報リスト) {
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
                            row.getShoKisaiHokenshaNo()));
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

    /**
     * 通知書発行情報を登録&更新する。
     *
     * @param 画面更新情報 List<dgtsuchishohakko_Row>
     */
    public void ＤＢ処理(List<dgtsuchishohakko_Row> 画面更新情報) {
        TsuchiShoriManager manager = TsuchiShoriManager.createInstance();
        List<TsuchishoHakkoJoho> tsuchishoHakkoJohoList = manager.通知書発行情報();
        boolean 更新Flag = false;
        for (dgtsuchishohakko_Row row : 画面更新情報) {
            for (TsuchishoHakkoJoho tsuchishoHakkoJoho : tsuchishoHakkoJohoList) {
                if (row.getShinseishoKanriNo().equals(tsuchishoHakkoJoho.get申請書管理番号().value())) {
                    tsuchishoHakkoJoho = tsuchishoHakkoJoho.createBuilderForEdit()
                            .set通知完了年月日(new FlexibleDate(RDate.getNowDate().toString()))
                            .build()
                            .modifiedModel();
                    manager.save(tsuchishoHakkoJoho);
                    更新Flag = true;
                }
            }
            if (!更新Flag) {
                TsuchishoHakkoJoho tsuchishoHakkoJoho = new TsuchishoHakkoJoho(
                        new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                        Code.EMPTY,
                        RString.EMPTY,
                        FlexibleDate.EMPTY,
                        FlexibleDate.EMPTY,
                        FlexibleDate.EMPTY,
                        FlexibleDate.EMPTY,
                        FlexibleDate.getNowDate());
                tsuchishoHakkoJoho = tsuchishoHakkoJoho.createBuilderForEdit().build().added();
                manager.save(tsuchishoHakkoJoho);
                更新Flag = false;
            }
        }
    }
}
