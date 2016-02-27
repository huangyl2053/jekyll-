/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.basic.hihokenshashohakkokanribo;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.hihokenshashohakkokanribo.HihokenshashoHakkoKanriboMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.AkasiHakouKanriEntity;

/**
 *
 * 被保険者証発行管理簿のマッパーインタフェースです。
 */
public interface IHihokenshashoHakkoKanriboMapper {

    /**
     * @param parameter 被保険者証発行管理簿_マッパー用のパラメータ
     * @return List<AkasiHakouKanriEntity> 証発行管理リストEntity
     */
    List<AkasiHakouKanriEntity> get証発行管理リスト情報(HihokenshashoHakkoKanriboMybatisParameter parameter);

}
