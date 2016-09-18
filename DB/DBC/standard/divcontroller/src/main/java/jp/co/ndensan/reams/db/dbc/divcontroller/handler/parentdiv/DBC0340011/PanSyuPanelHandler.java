/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0340011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC010020.DBC010020_KogakuServicehiJuryoininKeiyakuShoninKakuninshoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0340011.PanSyuPanelDiv;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額サービス費受領委任契約承認（不承認）確認書作成のハンドラクラスです。
 *
 * @reamsid_L DBC-1970-010 wangxingpeng
 */
public class PanSyuPanelHandler {

    private final PanSyuPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div PanSyuPanelDiv
     */
    public PanSyuPanelHandler(PanSyuPanelDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div PanSyuPanelDiv
     * @return ハンドラ
     */
    public static PanSyuPanelHandler of(PanSyuPanelDiv div) {
        return new PanSyuPanelHandler(div);
    }

    /**
     * is表示制御を変更のメソッドです。
     *
     * @return boolean
     */
    public boolean is表示制御を変更() {
        RDate 契約開始申請日 = div.getPanJyoken().getTxtKeyakuSinseibi().getFromValue();
        RDate 契約終了申請日 = div.getPanJyoken().getTxtKeyakuSinseibi().getToValue();
        RDate 契約開始決定日 = div.getPanJyoken().getTxtKeiyakuKeteibi().getFromValue();
        RDate 契約終了決定日 = div.getPanJyoken().getTxtKeiyakuKeteibi().getToValue();
        if (契約開始申請日 != null) {
            return false;
        }
        if (契約終了申請日 != null) {
            return false;
        }
        if (契約開始決定日 != null) {
            return false;
        }
        return 契約終了決定日 == null;
    }

    /**
     * getバッチのメソッドです。
     *
     * @return ResponseData
     * DBC010020_KogakuServicehiJuryoininKeiyakuShoninKakuninshoParameter
     */
    public DBC010020_KogakuServicehiJuryoininKeiyakuShoninKakuninshoParameter setバッチ() {
        RDate 契約開始申請日 = div.getPanJyoken().getTxtKeyakuSinseibi().getFromValue();
        RDate 契約終了申請日 = div.getPanJyoken().getTxtKeyakuSinseibi().getToValue();
        RDate 契約開始決定日 = div.getPanJyoken().getTxtKeiyakuKeteibi().getFromValue();
        RDate 契約終了決定日 = div.getPanJyoken().getTxtKeiyakuKeteibi().getToValue();
        RString 発行済 = div.getPanJyoken().getRadHakkouZumi().getSelectedKey();
        RDate 通知日 = div.getPanJyoken().getTxtTuutibi().getValue();
        RString 文書番号 = div.getPanJyoken().getCcdBunshoBango().get文書番号();
        Long 出力順ID = div.getCcdChohyoShutsuryokujun().get出力順ID();
        LasdecCode 市町村コード = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード();
        RDateTime 処理日時 = RDateTime.now();
        DBC010020_KogakuServicehiJuryoininKeiyakuShoninKakuninshoParameter parameter = new DBC010020_KogakuServicehiJuryoininKeiyakuShoninKakuninshoParameter();
        if (契約開始申請日 != null) {
            parameter.set契約申請開始(new FlexibleDate(契約開始申請日.toString()));
        }
        if (契約終了申請日 != null) {
            parameter.set契約申請終了(new FlexibleDate(契約終了申請日.toString()));
        }
        if (契約開始決定日 != null) {
            parameter.set契約決定開始(new FlexibleDate(契約開始決定日.toString()));
        }
        if (契約終了決定日 != null) {
            parameter.set契約決定終了(new FlexibleDate(契約終了決定日.toString()));
        }
        parameter.set発行済(発行済);
        if (通知日 != null) {
            parameter.set通知日(new FlexibleDate(通知日.toString()));
        }
        parameter.set文書番号(文書番号);
        if (出力順ID != null) {
            parameter.set改頁出力順ID(new RString(出力順ID));
        }
        parameter.set市町村コード(市町村コード);
        parameter.set処理日時(処理日時);
        return parameter;
    }

    /**
     * 前排他を設定のメソッドです。
     *
     * @return Boolean
     */
    public Boolean 前排他キーのセット() {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        LockingKey 排他キー = new LockingKey(controlData.getMenuID());
        return RealInitialLocker.tryGetLock(排他キー);
    }

    /**
     * 前排他を解除のメソッドです。
     */
    public void 前排他を解除する() {
        LockingKey key = new LockingKey(UrControlDataFactory.createInstance().getMenuID());
        RealInitialLocker.release(key);
    }
}
