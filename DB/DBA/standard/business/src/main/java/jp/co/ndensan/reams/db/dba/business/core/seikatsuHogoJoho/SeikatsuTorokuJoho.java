/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.seikatsuHogoJoho;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 生活保護情報登録情報です。
 *
 * @reamsid_L URU-5640-030 zhuxiaojun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeikatsuTorokuJoho implements Serializable {

    private SeikatsuJukyuShaJoho 生活保護受給者;
    private List<SeikatsuFujyoShubetsuJoho> 扶助種別リスト;
    private List<SeikatsuTeishiJoho> 停止期間リスト;
    private RString 選択標識;

}
