/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.jukyushokai;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.jukyushokai.JukyuShokaiShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.jukyushokai.JukyuShokaiShinseiNinteiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.jukyushokai.ServiceJukyuJokyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.ninteichosajokyo.NinteiChosaJokyoDataPassEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.annotations.Param;

/**
 * 受給照会（画面）のMybatisMapperクラスです。
 *
 * @reamsid_L DBD-3560-011 xuyue
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public interface IJukyushaShokaiMapper {

    /**
     * 被保険者番号より、申請一覧情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 削除事由コード 削除事由コード
     * @return 申請一覧情報
     */
    List<JukyuShokaiShinseiEntity> find申請情報(@Param("被保険者番号") HihokenshaNo 被保険者番号,
            @Param("削除事由コード") RString 削除事由コード);

    /**
     * 申請書管理番号より、申請認定情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 履歴番号 履歴番号
     * @param 枝番 枝番
     * @param 受給申請事由 受給申請事由
     * @param 被保険者番号 被保険者番号
     * @return 申請認定一覧情報
     */
    List<JukyuShokaiShinseiNinteiEntity> find申請認定情報(@Param("市町村コード") RString 市町村コード,
            @Param("履歴番号") RString 履歴番号,
            @Param("枝番") RString 枝番,
            @Param("受給申請事由") RString 受給申請事由,
            @Param("被保険者番号") RString 被保険者番号);

    /**
     * 被保険者番号より、利用者負担割合情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 利用者負担割合情報
     */
    DbT3114RiyoshaFutanWariaiMeisaiEntity get利用者負担割合(@Param("被保険者番号") HihokenshaNo 被保険者番号);

    /**
     * サービス受給状況を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return サービス受給状況
     */
    ServiceJukyuJokyoEntity findサービス受給状況(@Param("被保険者番号") HihokenshaNo 被保険者番号);

    /**
     * 履歴情報を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 認定日 FlexibleDate
     * @return List<NinteiChosaJokyoDataPassEntity>
     */
    public List<NinteiChosaJokyoDataPassEntity> get履歴情報(@Param("被保険者番号") HihokenshaNo 被保険者番号,
            @Param("認定日") FlexibleDate 認定日);
}
