package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.kaigojigyoshashisetsukanri;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJigyoshaParameter;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJigyoshaShisetsuKanriMapperParameter;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJogaiTokureiParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.kaigojigyoshashisetsukanrio.JigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.kaigojigyoshashisetsukanrio.KaigoJigyoshaRelateEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.kaigojigyosha.kaigojigyosha.KaigoJigyoshaEntity;

/**
 *
 * 介護事業者・施設管理のマッパーインタフェースです。
 *
 * @reamsid_L DBA-0340-010 wanghui
 */
public interface IKaigoJigyoshaShisetsuKanriMapper {

    /**
     * 事業者情報を取得します。
     *
     * @param parameter KaigoJigyoshaShisetsuKanriMapperParameter
     * @return 事業者情報取得
     */
    List<KaigoJigyoshaEntity> getJigyoshaJoho(KaigoJigyoshaShisetsuKanriMapperParameter parameter);

    /**
     * サービス一覧表示情報を取得します。
     *
     * @param parameter KaigoJigyoshaShisetsuKanriMapperParameter
     * @return サービス一覧表示情報取得
     */
    List<JigyoshaShiteiServiceEntity> getServiceItiranHyojiJoho(KaigoJogaiTokureiParameter parameter);
    
        /**
     * 事業者情報を登録されてない場合、サービス一覧表示情報を取得します。
     *
     * @param parameter KaigoJigyoshaShisetsuKanriMapperParameter
     * @return サービス一覧表示情報取得
     */
    List<JigyoshaShiteiServiceEntity> getServiceItiranHyojiJohoForEmpty(KaigoJogaiTokureiParameter parameter);
    
    /**
     * サービス一覧情報を取得します。
     *
     * @param parameter KaigoJigyoshaShisetsuKanriMapperParameter
     * @return サービス一覧情報取得
     */
    List<DbT7063KaigoJigyoshaShiteiServiceEntity> getServiceItiranJoho(KaigoJogaiTokureiParameter parameter);

    /**
     * 有効期間重複があるかどうかを判定する。
     *
     * @param parameter KaigoJigyoshaShisetsuKanriMapperParameter
     * @return サービス事業者
     */
    List<KaigoJigyoshaRelateEntity> getCheckKikanJufuku(KaigoJigyoshaParameter parameter);

    /**
     * 有効期間重複があるかどうかを判定する。
     *
     * @param parameter KaigoJigyoshaShisetsuKanriMapperParameter
     * @return その他特例施設または適用除外施設
     */
    List<KaigoJigyoshaRelateEntity> getCheckKikanJufukui(KaigoJigyoshaParameter parameter);
}
