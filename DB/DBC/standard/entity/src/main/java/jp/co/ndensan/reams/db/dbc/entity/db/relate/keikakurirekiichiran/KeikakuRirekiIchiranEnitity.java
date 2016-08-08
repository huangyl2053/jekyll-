/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.keikakurirekiichiran;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 居宅給付計画届出情報取得のEntityクラスです。
 *
 * @reamsid_L DBC-4350-080 liuxiaoyu
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KeikakuRirekiIchiranEnitity {

    private RString kyotakuKeikakuShurui;
    private HihokenshaNo hihokenshaNo;
    private FlexibleDate tekiyoKaishiYMD;
    private FlexibleDate tekiyoShuryoYMD;
    private JigyoshaNo keikakuJigyoshaNo;
    private JigyoshaNo itakusakiJigyoshaNo;
    private RString zanteiKubun;
}
