/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.tokuchoheijunka6gatsutsuchishoikkatsuhakko;

import jp.co.ndensan.reams.db.dbb.entity.TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko_sqlparamEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.tokuchoheijunka6gatsutsuchishoikkatsuhakko.TokuchoHeijunka6gatsuTsuchishoIkkatsuHakkoMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 特徴平準化（特徴6月分）通知書一括発行(バッチ)
 */
public class TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko {

    private final MapperProvider mapperProvider;
    private final TokuchoHeijunka6gatsuTsuchishoIkkatsuHakkoMapper mapper;
    private final TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko_sqlparamEntity sqlparams;

    /**
     * コンストラクタです。
     */
    public TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.mapper = mapperProvider.create(TokuchoHeijunka6gatsuTsuchishoIkkatsuHakkoMapper.class);
        this.sqlparams = new TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko_sqlparamEntity();
    }

    /**
     * 賦課情報取得
     *
     * @param 調定年度
     * @param 一括発行起動フラグ
     */
    public void getFukaJoho(RString 調定年度, boolean 一括発行起動フラグ) {
        sqlparams.set年度(調定年度);
        if (一括発行起動フラグ == true) {
            RString 基準日時 = mapper.get基準日時(sqlparams);
            //TODO 計算後情報作成バッチを呼び出す。
            mapper.select特徴平準化_6月分更新後とリアルのデータ(調定年度);
            mapper.update仮算定額変更情報一時テーブルの計算後情報更正前情報1(sqlparams);
        } else {
            mapper.select特徴平準化_6月分更新後のデータ();
            mapper.update仮算定額変更情報一時テーブルの計算後情報更正前情報2(sqlparams);
        }
        mapper.update更正前の対象者_追加含む_情報();
        //TODO 普徴納期情報リストと特徴納期情報リストの作成
        mapper.select全ての賦課情報();
        mapper.update前年度特徴期別金額06();
        mapper.update継続の被保険者区分();
        mapper.update4月開始の被保険者区分();
        mapper.update6月開始の被保険者区分();
    }

    /**
     * 通知書の発行
     */
    public void printTsuchisho() {
        //TODO 出力対象データの取得
        //TODO 帳票制御共通情報の取得
        DbT7065ChohyoSeigyoKyotsuDac dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
        DbT7065ChohyoSeigyoKyotsuEntity entity = dac.selectByKey(SubGyomuCode.DBB介護賦課,
                new ReportId("DBB100012_KarisanteiHenjunkaHenkoTsuchishoDaihyo"));
        //TODO 共通的な項目の編集を行う。
        //TODO ..

    }

    /**
     * 通知書発行後異動者登録
     *
     * @param 帳票作成日時 RString
     * @param 出力順ID RString
     * @param 出力対象区分 RString
     * @param 帳票ID RString
     */
    public void insTsuchishoHakkogoIdosha(
            RString 帳票作成日時, Long 出力順ID, RString 出力対象区分, RString 帳票ID
    ) {
        IOutputOrder ioutputorder = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBB介護賦課,
                        ReportId.EMPTY,
                        帳票ID, 出力順ID);
        //UrControlDataFactory.createInstance().getLoginInfo().getUserId();
        RString 出力順 = MyBatisOrderByClauseCreator.create(null, ioutputorder);
        mapper.insert入力の出力対象区分によって();

    }

}
