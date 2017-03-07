/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.ShinsakaiShiryoUpdateMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 委員用一次判定結果情報のProcessParameterです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiShiryoUpdateProcessParameter implements IBatchProcessParameter {

    private final RString 作成条件_範囲指定 = new RString("範囲指定");
    private final RString 作成条件_追加分 = new RString("追加分");
    private RString shinsakaiKaisaiNo;
    private RString sakuseiJoken;
    private int bangoStart;
    private int bangoEnd;
    private RString gogitaiDummyFlag;
    private final RString ダミー = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     * @param sakuseiJoken 作成条件（すべて・範囲・追加）
     * @param bangoStart int
     * @param bangoEnd int
     * @param gogitaiDummyFlag 合議体ダミーフラグ
     */
    public ShinsakaiShiryoUpdateProcessParameter(RString shinsakaiKaisaiNo, RString sakuseiJoken, int bangoStart, int bangoEnd, RString gogitaiDummyFlag) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
        this.sakuseiJoken = sakuseiJoken;
        this.bangoStart = bangoStart;
        this.bangoEnd = bangoEnd;
        this.gogitaiDummyFlag = gogitaiDummyFlag;
    }

    /**
     * 審査会資料作成の更新に関する基本情報のMyBatisParameterに転換します。
     *
     * @return ShinsakaiShiryoUpadateMyBatisParameter
     */
    public ShinsakaiShiryoUpdateMyBatisParameter toShinsakaiShiryoUpdateMyBatisParameter() {
        boolean isSakuseiJokenHani = false;
        boolean isSakuseiJokenTsuika = false;
        boolean isGogitaiDummyFlag = false;
        if (作成条件_範囲指定.equals(sakuseiJoken)) {
            isSakuseiJokenHani = true;
        }
        if (作成条件_追加分.equals(sakuseiJoken)) {
            isSakuseiJokenTsuika = true;
        }
        if (ダミー.equals(gogitaiDummyFlag)) {
            isGogitaiDummyFlag = true;
        }
        return new ShinsakaiShiryoUpdateMyBatisParameter(shinsakaiKaisaiNo, bangoStart, bangoEnd, isSakuseiJokenHani, isSakuseiJokenTsuika, isGogitaiDummyFlag);
    }
}
