/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.ninteishinseitorokuuketsuke;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5120001.NinteiShinseiTorokuUketsukeParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5120001.NinteiShinseiTorokuUketsukeEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.ninteichosajokyo.NinteiChosaJokyoDataPassEntity;

/**
 *
 * 要介護認定申請受付 Mapper
 *
 * @reamsid_L DBD-1300-010 huangh
 */
public interface INinteiShinseiTorokuUketsukeMapper {

    /**
     * 初期化情報を取得します。
     *
     * @param param NinteiShinseiTorokuUketsukeParameter
     * @return NinteiShinseiTorokuUketsukeEntity
     */
    NinteiShinseiTorokuUketsukeEntity get初期化情報(NinteiShinseiTorokuUketsukeParameter param);

    /**
     *
     * @param param NinteiShinseiTorokuUketsukeParameter
     * @return NinteiShinseiTorokuUketsukeEntity
     */
    NinteiShinseiTorokuUketsukeEntity get初期化情報_申請区分変更サービス変更修正(NinteiShinseiTorokuUketsukeParameter param);

    /**
     * 履歴情報を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<NinteiChosaJokyoDataPassEntity>
     */
    List<NinteiChosaJokyoDataPassEntity> get履歴情報(HihokenshaNo 被保険者番号);

}
