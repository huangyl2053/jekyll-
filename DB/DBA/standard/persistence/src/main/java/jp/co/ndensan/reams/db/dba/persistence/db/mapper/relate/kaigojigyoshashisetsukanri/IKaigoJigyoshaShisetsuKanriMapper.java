package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.kaigojigyoshashisetsukanri;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJigyoshaParameter;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJigyoshaShisetsuKanriMapperParameter;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJogaiTokureiParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.kaigojigyoshashisetsukanrio.KaigoJigyoshaRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.kaigojigyoshashisetsukanrio.KaigoJigyoshaShisetsuKanriRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.kaigojigyoshashisetsukanrio.KaigoJogaiTokureiRelateEntity;

/**
 *
 * 介護事業者・施設管理のマッパーインタフェースです。
 */
public interface IKaigoJigyoshaShisetsuKanriMapper {

    /**
     * 事業者情報取得を取得します。
     *
     * @param parameter KaigoJigyoshaShisetsuKanriMapperParameter
     * @return 事業者情報取得
     */
    List<KaigoJigyoshaShisetsuKanriRelateEntity> getJigyoshaJoho(KaigoJigyoshaShisetsuKanriMapperParameter parameter);

    /**
     * サービス一覧情報取得を取得します。
     *
     * @param parameter KaigoJigyoshaShisetsuKanriMapperParameter
     * @return サービス一覧情報取得
     */
    List<KaigoJogaiTokureiRelateEntity> getServiceItiranJoho(KaigoJogaiTokureiParameter parameter);

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
