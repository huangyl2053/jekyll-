/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosaitakusakimaster;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tyousai.koseishichosonmaster.KoseiShichosonMasterRelateEntity;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosaitakusaki.NinteichosaItakusakiKensakuParameter;

/**
 * 構成市町村マスタのマッパーインタフェースです。
 */
public interface INinteichosaItakusakiMasterMapper {

    /**
     * 検索条件に従い、調査委託先情報を検索する。
     *
     * @param parm 画面情報
     * @return List<KoseiShichosonMasterRelateEntity>
     */
    List<KoseiShichosonMasterRelateEntity> ninteichosaItakusakiSearch(NinteichosaItakusakiKensakuParameter parm);
}
