/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.ninteienkitsuchishohakko;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.ninteienkitsuchishohakko.NinteiEnkiTsuchishoHakkoParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.ninteienkitsuchishohakko.NinteiEnkiTsuchishoHakkoEntity;

/**
 * 認定延期通知発行のMapperです。
 *
 * @reamsid_L DBD-1410-010 wangjie2
 */
public interface INinteiEnkiTsuchishoHakkoMapper {

    /**
     * 居宅サービス計画情報を取得する。
     *
     * @param parameter パラメータ
     * @return 居宅サービス計画情報
     */
    List<NinteiEnkiTsuchishoHakkoEntity> get発行対象者一覧情報(NinteiEnkiTsuchishoHakkoParameter parameter);

}
