/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosakekkatorikomiocr;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosakekkatorikomiocr.NinteiOcrMapperParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosakekkatorikomiocr.NinteiChosaKekkaTorikomiOcrRelateEntity;

/**
 * 認定調査結果取込みを検索用クラスです。
 *
 * @reamsid_L DBE-1540-010 dongyabin
 */
public interface INinteiOcrMapper {

    /**
     * 当該被保険者の申請データを取得します。
     *
     * @param paramter パラメータ
     * @return 申請データ
     */
    List<NinteiChosaKekkaTorikomiOcrRelateEntity> get関連データ(NinteiOcrMapperParamter paramter);
}
