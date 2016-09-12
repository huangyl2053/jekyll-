/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 務局用概況特記一覧表情報です。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GaikyoTokkiEntity {

    private int dbt5502_shinsakaiOrder;
    private RString dbt5206_shuso;
    private RString dbt5206_kazokuJokyo;
    private RString dbt5206_kyojuKankyo;
    private RString dbt5206_kikaiKiki;
    private boolean isJimukyoku;
}
