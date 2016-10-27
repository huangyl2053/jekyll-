/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakushikyufushikyuketteitsuchihakko;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KogakuShikyuFushikyuKetteiTsuchiHakkoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakushikyufushikyuketteitsuchihakkoichiran.KogakuShikyuFushikyuKetteiTsuchiHakkoSource;

/**
 * 高額介護サービス費支給（不支給）決定通知一覧表HeaderEditorクラスです。
 *
 * @reamsid_L DBC-2000-080 wangxingpeng
 */
public class KogakuShikyuFushikyuKetteiTsuchiHakkoHeaderEditor
        implements IKogakuShikyuFushikyuKetteiTsuchiHakkoEditor {

    private final KogakuShikyuFushikyuKetteiTsuchiHakkoEntity entity;

    /**
     * コンストラクタです
     *
     * @param entity KogakuShikyuFushikyuKetteiTsuchiHakkoParameter
     */
    public KogakuShikyuFushikyuKetteiTsuchiHakkoHeaderEditor(KogakuShikyuFushikyuKetteiTsuchiHakkoEntity entity) {
        this.entity = entity;
    }

    @Override
    public KogakuShikyuFushikyuKetteiTsuchiHakkoSource edit(KogakuShikyuFushikyuKetteiTsuchiHakkoSource source) {
        if (entity != null) {
            source.ｔestPrint = entity.getテスト印刷();
            source.printTimeStamp = entity.get作成日時();
            source.hokenshaNo = entity.get市町村コード();
            source.hokenshaName = entity.get市町村名称();
            source.shutsuryokujun1 = entity.get並び順1();
            source.shutsuryokujun2 = entity.get並び順2();
            source.shutsuryokujun3 = entity.get並び順3();
            source.shutsuryokujun4 = entity.get並び順4();
            source.shutsuryokujun5 = entity.get並び順5();
            source.kaipage1 = entity.get改頁1();
            source.kaipage2 = entity.get改頁2();
            source.kaipage3 = entity.get改頁3();
            source.kaipage4 = entity.get改頁4();
            source.kaipage5 = entity.get改頁5();
        }
        return source;

    }

}
