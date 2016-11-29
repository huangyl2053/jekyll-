/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jikofutangakushomeishotoroku;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jikofutangakushomeishotoroku.JikofutangakuShomeishoTorokuParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jikofutangakushomeishotoroku.CheckResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jikofutangakushomeishotoroku.JikofutangakuShomeishoTorokuEntity;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 事業分自己負担額証明書登録（単）のインタフェースクラスです。
 *
 * @reamsid_L DBC-4820-010 sunhaidi
 */
public interface IJikofutangakuShomeishoTorokuMapper {

    /**
     * 事業高額合算自己負担額証明書情報を検索します。
     *
     * @param parameter JikofutangakuShomeishoTorokuParameter
     * @return List<DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity>
     */
    List<DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity> get事業高額合算自己負担額証明書情報(JikofutangakuShomeishoTorokuParameter parameter);

    /**
     * 事業高額合算自己負担額証明書履歴情報を検索します。
     *
     * @param parameter JikofutangakuShomeishoTorokuParameter
     * @return List<DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity>
     */
    List<DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity> get事業高額合算自己負担額証明書履歴情報(
            JikofutangakuShomeishoTorokuParameter parameter);

    /**
     * 事業高額合算支給申請書情報を検索します。
     *
     * @param parameter JikofutangakuShomeishoTorokuParameter
     * @return JikofutangakuShomeishoTorokuEntity
     */
    JikofutangakuShomeishoTorokuEntity get事業高額合算支給申請書情報(JikofutangakuShomeishoTorokuParameter parameter);

    /**
     * 事業高額合算自己負担額証明書Count数を検索します。
     *
     * @param parameter JikofutangakuShomeishoTorokuParameter
     * @return 検索結果
     */
    int get事業高額合算自己負担額証明書Count(JikofutangakuShomeishoTorokuParameter parameter);

    /**
     * 事業高額合算自己負担額証明書最新履歴番号を検索します。
     *
     * @param parameter JikofutangakuShomeishoTorokuParameter
     * @return 検索結果
     */
    Decimal get事業高額合算自己負担額証明書最新履歴番号(JikofutangakuShomeishoTorokuParameter parameter);

    /**
     * 受給者/総合次号対象者の判定の処理です。
     *
     * @param parameter JikofutangakuShomeishoTorokuParameter
     * @return 検索結果
     */
    CheckResultEntity judge受給者or総合次号対象者(JikofutangakuShomeishoTorokuParameter parameter);

}
