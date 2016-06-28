/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.kaigofukatokuchoheijunka8;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.kaigofukatokuchoheijunka8.HeijunkaKeisanPageJoho;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.kaigofukatokuchoheijunka8.KaigoFukaTokuchoHeijunka8FlowParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 特徴平準化（特徴8月分）のビジネスクラスです。
 *
 * @reamsid_L DBB-0860-040 yebangqiang
 */
public class KaigoFukaTokuchoHeijunka8 {

    private final DbT7022ShoriDateKanriDac dbT7022ShoriDateKanriDac;

    /**
     * コンストラクタです。
     */
    public KaigoFukaTokuchoHeijunka8() {
        dbT7022ShoriDateKanriDac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaigoFukaTokuchoHeijunka8}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KaigoFukaTokuchoHeijunka8}のインスタンス
     */
    public static KaigoFukaTokuchoHeijunka8 createInstance() {
        return InstanceProvider.create(KaigoFukaTokuchoHeijunka8.class);
    }

    /**
     * バッチパラメータの取得
     *
     * @param pageData 画面情報
     * @return batchParameterクラス
     */
    public KaigoFukaTokuchoHeijunka8FlowParameter getBatchiPara(HeijunkaKeisanPageJoho pageData) {
        KaigoFukaTokuchoHeijunka8FlowParameter batchParameter = new KaigoFukaTokuchoHeijunka8FlowParameter();
        batchParameter.set調定年度(pageData.get調定年度());
        batchParameter.set賦課年度(pageData.get賦課年度());
        batchParameter.set増額平準化方法(pageData.get増額平準化方法());
        batchParameter.set減額平準化方法(pageData.get減額平準化方法());
        batchParameter.set出力順ID(pageData.get出力順ID());
        return batchParameter;
    }

    /**
     * 処理状況取得
     *
     * @param 調定年度 調定年度
     * @return 処理状況リスト<処理日付管理entity>
     */
    public List<DbT7022ShoriDateKanriEntity> getShoriJohkyoList(FlexibleYear 調定年度) {
        List<DbT7022ShoriDateKanriEntity> shoriList = new ArrayList<>();
        DbT7022ShoriDateKanriEntity 当初所得引出 = dbT7022ShoriDateKanriDac.select処理日付管理マスタ_当初所得引出(調定年度);
        if (当初所得引出 != null) {
            shoriList.add(当初所得引出);
            return shoriList;
        }
        List<DbT7022ShoriDateKanriEntity> 当初所得引出以外 = dbT7022ShoriDateKanriDac.select処理日付管理マスタ_当初所得引出以外(調定年度);
        if (当初所得引出以外 != null) {
            shoriList.addAll(当初所得引出以外);
            return shoriList;
        }
        return shoriList;
    }

    /**
     * 特徴平準化8月分の処理状況取得
     *
     * @param 調定年度 調定年度
     * @return 特徴平準化8月分処理フラグ(※TRUE: 処理済み　FALSE：　未処理)
     */
    public boolean getHeijunka8MJyokyo(FlexibleYear 調定年度) {
        List<DbT7022ShoriDateKanriEntity> 特徴平準化8月分 = dbT7022ShoriDateKanriDac.select特徴平準化8月分処理(調定年度);
        if (特徴平準化8月分 == null) {
            return false;
        }
        for (DbT7022ShoriDateKanriEntity entity : 特徴平準化8月分) {
            if (entity.getKijunTimestamp() == null || entity.getKijunTimestamp().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
