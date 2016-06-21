/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.kyotakuservicekeikakuichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyotakuservicekeikakuichiran.JikoSakuseiKeikakuJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyotakuservicekeikakuichiran.KeikakuIraiJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyotakuservicekeikakuichiran.KyotakuServiceKeikakuIchiranEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyotakuservicekeikakuichiran.ServiceShuruiCodeEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * 共有子Div「居宅計画」のMapperです。
 *
 * @reamsid_L DBD-3560-080 huangh
 */
public interface IKyotakuServiceKeikakuIchiranMapper {

    /**
     * 初期化用居宅サービス計画情報を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<KyotakuServiceKeikakuIchiranEntity>
     */
    List<KyotakuServiceKeikakuIchiranEntity> get居宅サービス計画情報For初期化(HihokenshaNo 被保険者番号);

    /**
     * 事業者作成の計画依頼受付情報を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<KeikakuIraiJohoEntity>
     */
    List<KeikakuIraiJohoEntity> get計画依頼受付情報(HihokenshaNo 被保険者番号);

    /**
     * 事業者作成の計画依頼受付情報を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<ServiceShuruiCodeEntity>
     */
    List<ServiceShuruiCodeEntity> getサービス種類For計画依頼受付情報(HihokenshaNo 被保険者番号);

    /**
     * 自己作成計画情報を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<JikoSakuseiKeikakuJohoEntity>
     */
    List<JikoSakuseiKeikakuJohoEntity> get自己作成計画情報(HihokenshaNo 被保険者番号);
}
