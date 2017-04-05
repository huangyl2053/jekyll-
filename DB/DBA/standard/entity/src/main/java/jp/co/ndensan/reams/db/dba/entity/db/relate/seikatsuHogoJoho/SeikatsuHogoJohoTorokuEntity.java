/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.seikatsuHogoJoho;

import java.util.List;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0526SeikatsuHogoFujoShuruiEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0528SeikatsuHogoTeishikikanEntity;

/**
 * 生活保護情報登録情報のEntityです。
 *
 * @reamsid_L URU-5640-030 zhuxiaojun
 */
public class SeikatsuHogoJohoTorokuEntity {

    private List<UrT0508SeikatsuHogoJukyushaEntity> 生活保護受給者;
    private List<UrT0526SeikatsuHogoFujoShuruiEntity> 扶助種別リスト;
    private List<UrT0528SeikatsuHogoTeishikikanEntity> 停止期間リスト;

    /**
     * 生活保護受給者リストの取得です。
     *
     * @return 生活保護受給者リスト
     */
    public List<UrT0508SeikatsuHogoJukyushaEntity> get生活保護受給者リスト() {
        return 生活保護受給者;
    }

    /**
     * 扶助種別リストの取得です。
     *
     * @return 扶助種別リスト
     */
    public List<UrT0526SeikatsuHogoFujoShuruiEntity> get扶助種別リスト() {
        return 扶助種別リスト;
    }

    /**
     * 停止期間リストの取得です。
     *
     * @return 停止期間リスト
     */
    public List<UrT0528SeikatsuHogoTeishikikanEntity> get停止期間リスト() {
        return 停止期間リスト;
    }
}
