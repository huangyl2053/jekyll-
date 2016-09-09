/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kaigokyufuhikagomoshitateshoout;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kaigokyufuhikagomoshitateshoout.KagoMoshitateMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3059KagoMoshitateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090.DbWT1731KagoMoshitateTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090.KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090.KaigokyufuhiKagoMoshitateshoOutGetHihokenshaNoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090.KaigokyufuhiKagoMoshitateshoOutGetjigyoshaNameEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090.KaigokyufuhiKagoMoshitateshoOutgetCitySingleEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090.KaigokyufuhiKagoMoshitateshoOutgetCityWideAreaEntity;

/**
 * 介護給付費過誤申立書作成のマッパーインタフェースです。
 *
 * @reamsid_L DBC-2530-030 jiangwenkai
 */
public interface IKaigokyufuhiKagoMoshitateshoOutMapper {

    /**
     * 過誤申立データの取得
     *
     * @param parameter KagoMoshitateMybatisParameter
     * @return List<DbT3059KagoMoshitateEntity>
     */
    List<DbT3059KagoMoshitateEntity> select過誤申立データ(KagoMoshitateMybatisParameter parameter);

    /**
     * 保険者番号の取得
     *
     * @return List<KaigokyufuhiKagoMoshitateshoOutGetHihokenshaNoEntity>
     */
    List<KaigokyufuhiKagoMoshitateshoOutGetHihokenshaNoEntity> select保険者番号();

    /**
     * 送付除外区分の取得
     *
     * @return List<KaigokyufuhiKagoMoshitateshoOutGetHihokenshaNoEntity>
     */
    List<KaigokyufuhiKagoMoshitateshoOutGetHihokenshaNoEntity> select送付除外区分();

    /**
     * 事業者名称取得
     *
     * @return List<KaigokyufuhiKagoMoshitateshoOutGetjigyoshaNameEntity>
     */
    List<KaigokyufuhiKagoMoshitateshoOutGetjigyoshaNameEntity> select事業者名称();

    /**
     * 市町村セキュリティ情報取得_単一取得
     *
     * @return List<KaigokyufuhiKagoMoshitateshoOutgetCitySingleEntity>
     */
    List<KaigokyufuhiKagoMoshitateshoOutgetCitySingleEntity> select市町村_単一();

    /**
     * 市町村セキュリティ情報取得_広域取得
     *
     * @return List<KaigokyufuhiKagoMoshitateshoOutgetCityWideAreaEntity>
     */
    List<KaigokyufuhiKagoMoshitateshoOutgetCityWideAreaEntity> select市町村_広域();

    /**
     * 帳票出力取得
     *
     * @return List<KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity>
     */
    List<KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity> do帳票出力();

    /**
     * 保険者番号Errorの取得
     *
     * @return List<DbWT1731KagoMoshitateTempEntity>
     */
    List<DbWT1731KagoMoshitateTempEntity> select保険者番号Error();

    /**
     * 送付ファイルの取得
     *
     * @return List<KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity>
     */
    List<KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity> select送付ファイル();

    /**
     * DB更新_送付済
     *
     * @return List<DbT3059KagoMoshitateEntity>
     */
    List<DbT3059KagoMoshitateEntity> updatetDB_送付済();

    /**
     * DB更新_未送付
     *
     * @return List<DbT3059KagoMoshitateEntity>
     */
    List<DbT3059KagoMoshitateEntity> updatetDB_未送付();

}
