/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.kaigofukatokuchoheijunka8;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.kaigofukatokuchoheijunka8.HeijunkaKeisanPageJoho;
import jp.co.ndensan.reams.db.dbb.business.core.kaigofukatokuchoheijunka8.ShoriDateKanriEntityResult;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB013001.DBB013001_TokuchoHeinjunka8GatsuParameter;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoHeijunkaKeisanHoho8Gatsu;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteiidokanendo.HonsanteiIdoKanendoEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honsanteiidokanendo.IHonsanteiIdoKanendoMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 特徴平準化（特徴8月分）のビジネスクラスです。
 *
 * @reamsid_L DBB-0860-040 yebangqiang
 */
public class KaigoFukaTokuchoHeijunka8 {

    private final DbT7022ShoriDateKanriDac dbT7022ShoriDateKanriDac;
    private final MapperProvider mapperProvider;
    private static final RString 年度内連番 = new RString("0001");
    private static final RString 処理枝番 = new RString("0001");

    /**
     * コンストラクタです。
     */
    public KaigoFukaTokuchoHeijunka8() {
        dbT7022ShoriDateKanriDac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
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
    public DBB013001_TokuchoHeinjunka8GatsuParameter getBatchiPara(HeijunkaKeisanPageJoho pageData) {
        DBB013001_TokuchoHeinjunka8GatsuParameter batchParameter = new DBB013001_TokuchoHeinjunka8GatsuParameter();
        batchParameter.set調定年度(pageData.get調定年度());
        batchParameter.set賦課年度(pageData.get賦課年度());
        if (TokuchoHeijunkaKeisanHoho8Gatsu.平準化しない.get略称().equals(pageData.get増額平準化方法())) {
            batchParameter.set増額平準化方法(TokuchoHeijunkaKeisanHoho8Gatsu.平準化しない.getコード());
        } else if (TokuchoHeijunkaKeisanHoho8Gatsu.前半と後半を１_１にする.get略称().equals(pageData.get増額平準化方法())) {
            batchParameter.set増額平準化方法(TokuchoHeijunkaKeisanHoho8Gatsu.前半と後半を１_１にする.getコード());
        } else if (TokuchoHeijunkaKeisanHoho8Gatsu.年額より特徴３期分を含まない仮徴収額を引いた額を４期で割る.get略称().equals(
                pageData.get増額平準化方法())) {
            batchParameter.set増額平準化方法(
                    TokuchoHeijunkaKeisanHoho8Gatsu.年額より特徴３期分を含まない仮徴収額を引いた額を４期で割る.getコード());
        }
        if (TokuchoHeijunkaKeisanHoho8Gatsu.平準化しない.get略称().equals(pageData.get減額平準化方法())) {
            batchParameter.set減額平準化方法(TokuchoHeijunkaKeisanHoho8Gatsu.平準化しない.getコード());
        } else if (TokuchoHeijunkaKeisanHoho8Gatsu.前半と後半を１_１にする.get略称().equals(pageData.get減額平準化方法())) {
            batchParameter.set減額平準化方法(TokuchoHeijunkaKeisanHoho8Gatsu.前半と後半を１_１にする.getコード());
        } else if (TokuchoHeijunkaKeisanHoho8Gatsu.年額より特徴３期分を含まない仮徴収額を引いた額を４期で割る.get略称().equals(
                pageData.get減額平準化方法())) {
            batchParameter.set減額平準化方法(
                    TokuchoHeijunkaKeisanHoho8Gatsu.年額より特徴３期分を含まない仮徴収額を引いた額を４期で割る.getコード());
        }
        batchParameter.set出力順ID(pageData.get出力順ID());
        return batchParameter;
    }

    /**
     * 処理状況取得
     *
     * @param 調定年度 調定年度
     * @return 処理状況リスト<処理日付管理entity>
     */
    public List<ShoriDateKanriEntityResult> getShoriJohkyoList(FlexibleYear 調定年度) {
        List<ShoriDateKanriEntityResult> shoriList = new ArrayList<>();
        DbT7022ShoriDateKanriEntity 当初所得引出 = dbT7022ShoriDateKanriDac.select処理日付管理マスタ_当初所得引出(調定年度, ShoriName.当初所得引出.get名称());
        if (当初所得引出 != null) {
            ShoriDateKanriEntityResult result = new ShoriDateKanriEntityResult();
            result.setEntity(当初所得引出);
            shoriList.add(result);
        }
        List<DbT7022ShoriDateKanriEntity> 当初所得引出以外 = dbT7022ShoriDateKanriDac
                .select処理日付管理マスタ_当初所得引出以外(調定年度, ShoriName.依頼金額計算.get名称(),
                        ShoriName.特徴異動情報作成.get名称(), ShoriName.本算定賦課.get名称());
        if (当初所得引出以外 != null) {
            for (DbT7022ShoriDateKanriEntity entity : 当初所得引出以外) {
                ShoriDateKanriEntityResult result = new ShoriDateKanriEntityResult();
                result.setEntity(entity);
                shoriList.add(result);
            }
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
        List<DbT7022ShoriDateKanriEntity> 特徴平準化8月分 = dbT7022ShoriDateKanriDac.selectBySomeKeys(
                SubGyomuCode.DBB介護賦課, ShoriName.特徴平準化_8月分_確定.get名称(), 処理枝番, 調定年度, 年度内連番);
        if (特徴平準化8月分 == null || 特徴平準化8月分.isEmpty()) {
            return false;
        }
        for (DbT7022ShoriDateKanriEntity entity : 特徴平準化8月分) {
            if (entity.getKijunTimestamp() == null || entity.getKijunTimestamp().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 処理日時取得
     *
     * @return RDateTime
     */
    public RDateTime getMax確定日時() {
        IHonsanteiIdoKanendoMapper mapper = mapperProvider.create(IHonsanteiIdoKanendoMapper.class);
        HonsanteiIdoKanendoEntity entity = mapper.select確定日時();
        if (entity != null) {
            return entity.get確定日時();
        }
        return null;
    }
}
