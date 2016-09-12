/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai;

import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * 務局用概況特記一覧表情報です。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ImjJohoEntity {

    private int dbt5502_shinsakaiOrder;
    private RDateTime dbt5115_imageSharedFileId;
    private boolean isJimukyoku;
}
