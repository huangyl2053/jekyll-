/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.param;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 共同処理用受給者異動情報Entity
 *
 * @reamsid_L DBC-1950-030 chenaoqi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyodoshoriyoJukyushaIdoRenrakuhyoParam implements Serializable {

    private KyoutuuEntity 共通項目Entity;
    private DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity 基本情報Entity;
    private DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity 償還情報Entity;
    private DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity 高額情報Entity;
}
