/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.kouhoushajoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.kouhoushajoho.KouhoushaJohoParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kouhoushajoho.KouhoushaJohoEntity;

/**
 * 候補者情報を取得する。
 *
 * @reamsid_L DBD-3530-060 liuyl
 */
public interface IKouhoushaJohoMapper {

    List<KouhoushaJohoEntity> find候補者情報(KouhoushaJohoParameter parameter);
}
