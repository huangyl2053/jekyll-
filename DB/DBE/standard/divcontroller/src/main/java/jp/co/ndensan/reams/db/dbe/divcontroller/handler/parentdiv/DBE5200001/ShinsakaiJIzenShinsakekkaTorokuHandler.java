/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5200001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiJizenKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaijizenshinsakekkaichiran.JizenShinsaKekkaJokyo;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaijizenshinsakekkaichiran.JizenShinsakaiShiryo;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5200001.DgBeforeShinsakaiResult_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5200001.ShinsakaiJIzenShinsakekkaTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5200001.ShinsakaikekkaIchiranInputCsvEntity;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaijizenshinsakekkaichiran.ShinsakaiJIzenshinsakekkaIchiranManager;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護認定審査会委員事前審査結果登録の画面処理Handlerクラスです。
 *
 * @reamsid_L DBE-1640-010 zhaoyao
 */
public class ShinsakaiJIzenShinsakekkaTorokuHandler {

    private final ShinsakaiJIzenShinsakekkaTorokuDiv div;
    private static final int ZERO = 0;
    private static final int ITI = 1;
    private static final RString KAKO_MIGI = new RString(")");
    private static final RString KAKO_HITARI = new RString("(");

    /**
     * 画面初期状態の設定です。
     *
     * @param 事前審査会用結果リスト 事前審査会用結果リスト
     */
    public void set事前審査会用結果(List<JizenShinsakaiShiryo> 事前審査会用結果リスト) {
        if (!事前審査会用結果リスト.isEmpty()) {
            JizenShinsakaiShiryo 事前審査会用結果 = 事前審査会用結果リスト.get(ZERO);
            div.getJizenShinsakaiShiryoPublication().getPublicationTargetShinsakai().getTxtShinsakaiKaisaiNo()
                    .setValue(事前審査会用結果.getShinsakaiKaisaiNo());
            div.getJizenShinsakaiShiryoPublication().getPublicationTargetShinsakai().getTxtShinsakaiYoteiDate()
                    .setValue(new FlexibleDate(事前審査会用結果.getShinsakaiKaisaiYoteiYMD()));
            div.getJizenShinsakaiShiryoPublication().getPublicationTargetShinsakai().getTxtShinsakaiKaijo()
                    .setValue(事前審査会用結果.getShinsakaiKaisaiBashoName());
            div.getJizenShinsakaiShiryoPublication().getPublicationTargetShinsakai().getTxtShinsakaiKaishiYoteiTime()
                    .setValue(new RTime(事前審査会用結果.getShinsakaiKaishiYoteiTime()));
            div.getJizenShinsakaiShiryoPublication().getPublicationTargetShinsakai().getTxtShiryoSakusei()
                    .setValue(new RString(Boolean.valueOf(事前審査会用結果.isShiryoSakuseiZumiFlag()).toString()));
            div.getJizenShinsakaiShiryoPublication().getPublicationTargetShinsakai().getTxtGogitaiNo()
                    .setValue(事前審査会用結果.getShinsakaiKaisaiNo());
            div.getJizenShinsakaiShiryoPublication().getPublicationTargetShinsakai().getTxtGogitaiName()
                    .setValue(事前審査会用結果.getGogitaiMei());
            div.getJizenShinsakaiShiryoPublication().getPublicationTargetShinsakai().getTxtYoteiTeiin()
                    .setValue(new Decimal(事前審査会用結果.getShinsakaiYoteiTeiin()));
            div.getJizenShinsakaiShiryoPublication().getPublicationTargetShinsakai().getTxtWariateNinzu()
                    .setValue(new Decimal(事前審査会用結果.getShinsakaiWariateZumiNinzu()));
        }
    }

    /**
     * 画面初期状態の設定です。
     *
     * @param 事前審査結果リスト 事前審査結果リスト
     */
    public void set事前審査結果(List<JizenShinsaKekkaJokyo> 事前審査結果リスト) {
        if (!事前審査結果リスト.isEmpty()) {
            List<DgBeforeShinsakaiResult_Row> rowList = new ArrayList<>();
            int flg = ZERO;
            div.getPublicationResult().getDgBeforeShinsakaiResult().getGridSetting().getColumn(new RString("shinsain1"))
                    .setColumnName(事前審査結果リスト.get(ZERO).getShisain1());
            div.getPublicationResult().getDgBeforeShinsakaiResult().getGridSetting().getColumn(new RString("shinsain2"))
                    .setColumnName(事前審査結果リスト.get(ZERO).getShisain2());
            div.getPublicationResult().getDgBeforeShinsakaiResult().getGridSetting().getColumn(new RString("shinsain3"))
                    .setColumnName(事前審査結果リスト.get(ZERO).getShisain3());
            div.getPublicationResult().getDgBeforeShinsakaiResult().getGridSetting().getColumn(new RString("shinsain4"))
                    .setColumnName(事前審査結果リスト.get(ZERO).getShisain4());
            div.getPublicationResult().getDgBeforeShinsakaiResult().getGridSetting().getColumn(new RString("shinsain5"))
                    .setColumnName(事前審査結果リスト.get(ZERO).getShisain5());
            for (JizenShinsaKekkaJokyo data : 事前審査結果リスト) {
                if (flg == ZERO) {
                    flg = ITI;
                    continue;
                }
                DgBeforeShinsakaiResult_Row row = new DgBeforeShinsakaiResult_Row(
                        data.getShinsakaiOrder(),
                        toValue(data.getShisain1()),
                        toValue(data.getShisain2()),
                        toValue(data.getShisain3()),
                        toValue(data.getShisain4()),
                        toValue(data.getShisain5()));
                rowList.add(row);
            }
            div.getPublicationResult().getDgBeforeShinsakaiResult().setDataSource(rowList);
        }
    }

    /**
     * DB更新処理
     *
     * @param csvEntityList csvEntityList
     * @return 更新フラグ
     */
    public boolean onclick_btnGetResult(List<ShinsakaikekkaIchiranInputCsvEntity> csvEntityList) {
        return selectByKey(csvEntityList);
    }

    private boolean saveCsvDataInput(ShinsakaikekkaIchiranInputCsvEntity csvEntity, ShinsakaiJizenKekkaJoho dacEntity, int flg) {
        if (flg == ZERO) {
            ShinsakaiJizenKekkaJoho kekkaEntity = new ShinsakaiJizenKekkaJoho(
                    csvEntity.getShinsakaiKaisaiNo(), csvEntity.getShinsakaiIinCode(), Integer.parseInt(csvEntity.getShinsakaiOrder().toString()));
            kekkaEntity = kekkaEntity.createBuilderForEdit().set二次判定結果コード(new Code(csvEntity.getNijiHanteiKekkaCode()))
                    .set有効期間(Integer.parseInt(csvEntity.getYukokikan().toString())).build();
            return ShinsakaiJIzenshinsakekkaIchiranManager.createInstance().saveCsvDataInput(kekkaEntity);
        } else {
            dacEntity = dacEntity.createBuilderForEdit().set二次判定結果コード(new Code(csvEntity.getNijiHanteiKekkaCode()))
                    .set有効期間(Integer.parseInt(csvEntity.getYukokikan().toString())).build();
            return ShinsakaiJIzenshinsakekkaIchiranManager.createInstance().saveCsvDataInput(dacEntity);
        }
    }

    private boolean selectByKey(List<ShinsakaikekkaIchiranInputCsvEntity> csvEntityList) {
        boolean 判定ふらぐ = false;
        for (ShinsakaikekkaIchiranInputCsvEntity csvEntity : csvEntityList) {
            if (ShinsakaiJIzenshinsakekkaIchiranManager.createInstance()
                    .selectByKey(csvEntity.getShinsakaiKaisaiNo(), csvEntity.getShinsakaiIinCode(),
                            Integer.parseInt(csvEntity.getShinsakaiOrder().toString())) == null) {
                判定ふらぐ = saveCsvDataInput(csvEntity, null, ZERO);
            } else {
                判定ふらぐ = saveCsvDataInput(csvEntity, new ShinsakaiJizenKekkaJoho(ShinsakaiJIzenshinsakekkaIchiranManager.createInstance()
                        .selectByKey(csvEntity.getShinsakaiKaisaiNo(), csvEntity.getShinsakaiIinCode(),
                                Integer.parseInt(csvEntity.getShinsakaiOrder().toString()))), ITI);
            }
        }
        return 判定ふらぐ;
    }

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public ShinsakaiJIzenShinsakekkaTorokuHandler(ShinsakaiJIzenShinsakekkaTorokuDiv div) {
        this.div = div;
    }

    private RString toValue(RString 状態) {
        if (状態 == null) {
            return RString.EMPTY;
        } else {
            return new RStringBuilder(YokaigoJotaiKubun09.toValue(状態)
                    .get略称()).append(KAKO_HITARI).append(状態).append(KAKO_MIGI).toRString();
        }
    }
}
