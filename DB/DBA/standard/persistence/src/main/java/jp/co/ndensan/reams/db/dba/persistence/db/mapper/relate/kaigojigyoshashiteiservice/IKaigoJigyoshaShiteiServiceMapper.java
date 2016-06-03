package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.kaigojigyoshashiteiservice;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.db.relate.kaigojigyoshashisetsukanrio.KaigoJogaiTokureiRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * 介護事業者登録のマッパーインタフェースです。
 *
 * @reamsid_L DBA-0340-050 lijia
 */
public interface IKaigoJigyoshaShiteiServiceMapper {

    /**
     * サービス一覧履歴情報を取得します。
     *
     * @param systemDate システム日付
     * @return サービス一覧情報取得
     */
    List<KaigoJogaiTokureiRelateEntity> getKaigoJigyoshaShiteiServiceRireki(FlexibleDate systemDate);

    /**
     * サービス一覧有効情報を取得します。
     *
     * @param systemDate システム日付
     * @return サービス一覧情報取得
     */
    List<KaigoJogaiTokureiRelateEntity> getKaigoJigyoshaShiteiService(FlexibleDate systemDate);
}
