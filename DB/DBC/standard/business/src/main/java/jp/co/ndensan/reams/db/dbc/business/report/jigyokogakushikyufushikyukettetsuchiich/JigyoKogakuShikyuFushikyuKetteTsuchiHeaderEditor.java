/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jigyokogakushikyufushikyukettetsuchiich;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.JigyoKogakuShikyuFushikyuKetteTsuchiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.jigyokogakushikyufushikyukettetsuchiichiran.JigyoKogakuShikyuFushikyuKetteTsuchiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業高額支給不支給決定通知一覧表HeaderEditorクラスです。
 *
 * @reamsid_L DBC-2000-110 wangxingpeng
 */
public class JigyoKogakuShikyuFushikyuKetteTsuchiHeaderEditor implements IJigyoKogakuShikyuFushikyuKetteTsuchiEditor {

    private final JigyoKogakuShikyuFushikyuKetteTsuchiEntity entity;
    private static final RString TRUE = new RString("true");
    private static final RString FLASE = new RString("flase");
    private static final RString テスト印刷 = new RString("テスト印刷");

    /**
     * コンストラクタです
     *
     * @param entity JigyoKogakuShikyuFushikyuKetteTsuchiEntity
     */
    public JigyoKogakuShikyuFushikyuKetteTsuchiHeaderEditor(JigyoKogakuShikyuFushikyuKetteTsuchiEntity entity) {
        this.entity = entity;

    }

    @Override
    public JigyoKogakuShikyuFushikyuKetteTsuchiSource edit(JigyoKogakuShikyuFushikyuKetteTsuchiSource source) {
        if (null != entity) {

            if (TRUE.equals(entity.getテスト出力フラグ())) {
                source.testPrint = テスト印刷;
            } else if (FLASE.equals(entity.getテスト出力フラグ())) {
                source.testPrint = null;
            }
            source.printTimeStamp = entity.get作成日時();
            source.hokenshaNo = entity.get市町村コード();
            source.hokenshaName = entity.get市町村名称();
            source.shutsuryokujun1 = entity.get並び順１();
            source.shutsuryokujun2 = entity.get並び順２();
            source.shutsuryokujun3 = entity.get並び順３();
            source.shutsuryokujun4 = entity.get並び順４();
            source.shutsuryokujun5 = entity.get並び順５();
            source.kaipage1 = entity.get改頁１();
            source.kaipage2 = entity.get改頁２();
            source.kaipage3 = entity.get改頁３();
            source.kaipage4 = entity.get改頁４();
            source.kaipage5 = entity.get改頁５();
        }
        return source;
    }
}
