/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010;

import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.BangoseidoNinteisumiKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ChukanHyojunLayoutYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.DataSetNo;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShinkiIdoKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.TeikyoKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.TokuteiKojinJohomeiCode;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo.JukyushaKihonJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.JukyushaKihonJohoProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.JukyushaTeikyoJohoKohoEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.TeikyoKihonJohoNNTempEntity;
import jp.co.ndensan.reams.db.dbu.service.core.tokuteikojinjohoteikyo.TokuteiKojinJohoTeikyoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ShinseiJokyoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.YukoMukoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 受給者基本情報のバッチ処理です。
 *
 * @reamsid_L DBU-4880-050 wangxiaodong
 */
public class JukyushaKihonJohoTeikyoJohoSyutokuProcess extends BatchProcessBase<JukyushaTeikyoJohoKohoEntity> {

    private static final RString GET_JUKYUSHATEIKYOJOHOKOHO = new RString("jp.co.ndensan.reams"
            + ".db.dbu.persistence.db.mapper.relate.tokuteikojinjohoteikyo.getJukyushaDaichoTeikyoJohoKoho");
    private static final RString 未設定事由 = new RString("NotAcceptable");
    private static final RString 未設定事由８ = new RString("NotConvered");
    private JukyushaKihonJohoProcessParameter processParameter;
    private JukyushaKihonJohoMybatisParameter mybitisParamter;
    private RString 特定個人情報名コード;
    private RString 版番号;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter teikyoKihonJohoNNTemp;

    @Override
    protected void initialize() {
        特定個人情報名コード = processParameter.get特定個人情報名コード();
        版番号 = TokuteiKojinJohoTeikyoManager.createInstance()
                .get版番号(processParameter.get新規異動区分().getコード(), 特定個人情報名コード,
                        DataSetNo._0201受給者基本情報.getコード(), FlexibleDate.getNowDate()).get(0).get版番号();
        mybitisParamter = processParameter.toJukyushaKihonJohoMybatisParameter();
        mybitisParamter.setYukoMukoKubun(YukoMukoKubun.無効.getコード());
        if (processParameter.get新規異動区分() == ShinkiIdoKubun.異動) {
            mybitisParamter.setShinkiIdo(true);
        } else {
            mybitisParamter.setShinkiIdo(false);
        }
        mybitisParamter.setTeikyoKubun_SonotaError(TeikyoKubun.その他エラーにより未提供.getコード());
        mybitisParamter.setTeikyoKubun_KojinBango(TeikyoKubun.個人番号未設定により未提供.getコード());
        mybitisParamter.setDataSetRecordKey(DataSetNo._0201受給者基本情報.getコード());
        mybitisParamter.setHanNo(版番号);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(GET_JUKYUSHATEIKYOJOHOKOHO, mybitisParamter);
    }

    @Override
    protected void createWriter() {
        teikyoKihonJohoNNTemp = new BatchEntityCreatedTempTableWriter(
                processParameter.get提供基本情報中間テーブル名(), TeikyoKihonJohoNNTempEntity.class);
    }

    @Override
    protected void process(JukyushaTeikyoJohoKohoEntity entity) {
        TeikyoKihonJohoNNTempEntity tempEntity = new TeikyoKihonJohoNNTempEntity();
        tempEntity.setHihokenshaNo(entity.getHihokenshaNo());
        tempEntity.setDataSetKey(getデータセットキー(entity));
        tempEntity.setTeikyoKubun(RString.EMPTY);
        tempEntity.setShikibetsuCode(entity.getShikibetsuCode());
        tempEntity.setTokuteiKojinJohoMeiCode(特定個人情報名コード);
        tempEntity.setHanNo(版番号);
        tempEntity.setTeikyoNaiyo01(get要介護状態区分コード(entity));
        tempEntity.setMisetteiJiyu01(RString.EMPTY);
        tempEntity.setTeikyoNaiyo02(get認定済区分(entity));
        tempEntity.setMisetteiJiyu02(RString.EMPTY);
        if (TokuteiKojinJohomeiCode.特定個人情報版管理番号36.getコード().equals(特定個人情報名コード)
                || TokuteiKojinJohomeiCode.特定個人情報版管理番号46.getコード().equals(特定個人情報名コード)) {
            tempEntity.setTeikyoNaiyo03(new RString(entity.getNinteiYMD().toString()));
            tempEntity.setMisetteiJiyu03(RString.EMPTY);
        }
        tempEntity.setTeikyoNaiyo04(getValue(entity.getNinteiYukoKikanKaishiYMD()));
        tempEntity.setMisetteiJiyu04(get未設定事由(entity.getNinteiYukoKikanKaishiYMD()));
        tempEntity.setTeikyoNaiyo05(getValue(entity.getNinteiYukoKikanShuryoYMD()));
        tempEntity.setMisetteiJiyu05(get未設定事由(entity.getNinteiYukoKikanShuryoYMD()));
        tempEntity.setTeikyoNaiyo06(getValue(entity.getJukyuShinseiYMD()));
        tempEntity.setMisetteiJiyu06(get未設定事由(entity.getJukyuShinseiYMD()));
        tempEntity.setTeikyoNaiyo07(entity.getNinteishinsakaiIkenShurui());
        tempEntity.setMisetteiJiyu07(get未設定事由(entity.getNinteishinsakaiIkenShurui()));
        tempEntity.setTeikyoNaiyo08(RString.EMPTY);
        tempEntity.setMisetteiJiyu08(未設定事由８);
        tempEntity.setTeikyoNaiyo09(getValue(entity.getShikyuGendoTanisu()));
        tempEntity.setMisetteiJiyu09(get未設定事由(entity.getShikyuGendoTanisu()));
        tempEntity.setTeikyoNaiyo10(RString.EMPTY);
        tempEntity.setMisetteiJiyu10(RString.EMPTY);
        tempEntity.setMisetteiJiyu10(RString.EMPTY);
        tempEntity.setKokaiYMD(FlexibleDate.getNowDate());
        teikyoKihonJohoNNTemp.insert(tempEntity);
    }

    private RString getデータセットキー(JukyushaTeikyoJohoKohoEntity entity) {
        return entity.getHihokenshaNo().value().concat(
                DataSetNo._0201受給者基本情報.getコード()).concat(
                        entity.getJukyuShinseiYMD().toString());
    }

    private RString get要介護状態区分コード(JukyushaTeikyoJohoKohoEntity entity) {
        if (YokaigoJotaiKubun.非該当.getコード().equals(entity.getYokaigoJotaiKubunCode().value())) {
            return ChukanHyojunLayoutYokaigoJotaiKubun.自立.getコード();
        } else if (YokaigoJotaiKubun.要支援_経過的要介護.getコード().equals(entity.getYokaigoJotaiKubunCode().value())) {
            return ChukanHyojunLayoutYokaigoJotaiKubun.経過的要介護.getコード();
        } else if (YokaigoJotaiKubun.要支援1.getコード().equals(entity.getYokaigoJotaiKubunCode().value())) {
            return ChukanHyojunLayoutYokaigoJotaiKubun.要支援1.getコード();
        } else if (YokaigoJotaiKubun.要支援2.getコード().equals(entity.getYokaigoJotaiKubunCode().value())) {
            return ChukanHyojunLayoutYokaigoJotaiKubun.要支援2.getコード();
        } else if (YokaigoJotaiKubun.要介護1.getコード().equals(entity.getYokaigoJotaiKubunCode().value())) {
            return ChukanHyojunLayoutYokaigoJotaiKubun.要介護1.getコード();
        } else if (YokaigoJotaiKubun.要介護2.getコード().equals(entity.getYokaigoJotaiKubunCode().value())) {
            return ChukanHyojunLayoutYokaigoJotaiKubun.要介護2.getコード();
        } else if (YokaigoJotaiKubun.要介護3.getコード().equals(entity.getYokaigoJotaiKubunCode().value())) {
            return ChukanHyojunLayoutYokaigoJotaiKubun.要介護3.getコード();
        } else if (YokaigoJotaiKubun.要介護4.getコード().equals(entity.getYokaigoJotaiKubunCode().value())) {
            return ChukanHyojunLayoutYokaigoJotaiKubun.要介護4.getコード();
        } else if (YokaigoJotaiKubun.要介護5.getコード().equals(entity.getYokaigoJotaiKubunCode().value())) {
            return ChukanHyojunLayoutYokaigoJotaiKubun.要介護5.getコード();
        } else if (ShinseiJokyoKubun.申請中.getコード().equals(entity.getShinseiJokyoKubun())) {
            return ChukanHyojunLayoutYokaigoJotaiKubun.なし.getコード();
        }
        return ChukanHyojunLayoutYokaigoJotaiKubun.なし.getコード();
    }

    private RString get認定済区分(JukyushaTeikyoJohoKohoEntity entity) {
        if (ShinseiJokyoKubun.申請中.getコード().equals(entity.getShinseiJokyoKubun())) {
            return BangoseidoNinteisumiKubun.申請中.getコード();
        } else if (ShinseiJokyoKubun.認定完了.getコード().equals(entity.getShinseiJokyoKubun())) {
            return BangoseidoNinteisumiKubun.認定済.getコード();
        }
        return RString.EMPTY;
    }

    private RString get未設定事由(Decimal 提供内容) {
        if (提供内容 == null || Decimal.ZERO.equals(提供内容)) {
            return 未設定事由;
        }
        return RString.EMPTY;
    }

    private RString get未設定事由(FlexibleDate 日付) {
        if (isNullOrEmpty(日付)) {
            return 未設定事由;
        }
        return RString.EMPTY;
    }

    private RString get未設定事由(RString 提供内容) {
        if (RString.isNullOrEmpty(提供内容)) {
            return 未設定事由;
        }
        return RString.EMPTY;
    }

    private RString getValue(Decimal 提供内容) {
        if (提供内容 == null) {
            return null;
        }
        return new RString(提供内容.toString());
    }

    private RString getValue(FlexibleDate 日付) {
        if (isNullOrEmpty(日付)) {
            return RString.EMPTY;
        }
        return new RString(日付.toString());
    }

    private boolean isNullOrEmpty(FlexibleDate 日付) {
        return 日付 == null || 日付.isEmpty();
    }
}
