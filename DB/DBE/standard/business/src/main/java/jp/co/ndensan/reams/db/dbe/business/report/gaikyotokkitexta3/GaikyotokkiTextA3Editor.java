/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.gaikyotokkitexta3;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.gaikyotokkitexta3.GaikyotokkiTextA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.gaikyotokkitexta3.GaikyotokkiTextA3ReportSource;

/**
 * 事務局用概況特記のEditorです。
 *
 * @reamsid_L DBE-0150-070 wangrenze
 */
public class GaikyotokkiTextA3Editor implements IGaikyotokkiTextA3Editor {

    private final GaikyotokkiTextA3Entity item;

    /**
     * コンストラクタです。
     *
     * @param item {@link GaikyotokkiTextA3Entity}
     */
    protected GaikyotokkiTextA3Editor(GaikyotokkiTextA3Entity item) {
        this.item = item;
    }

    /**
     * 事務局用概況特記を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public GaikyotokkiTextA3ReportSource edit(GaikyotokkiTextA3ReportSource source) {
        source.gaikyotokkiText = item.get概況特記Text();
        source.gaikyotokkiImg = item.get概況特記Img();

        source.two_gaikyotokkiImg = item.get概況特記Img();
        return source;
    }

}
