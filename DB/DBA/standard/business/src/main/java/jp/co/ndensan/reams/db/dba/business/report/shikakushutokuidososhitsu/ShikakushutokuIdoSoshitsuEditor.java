/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.shikakushutokuidososhitsu;

import jp.co.ndensan.reams.db.dba.entity.report.shikakushutokuidososhitsu.ShikakushutokuIdoSoshitsuReportSource;

/**
 *
 * 被保険者証発行一覧表Editorです。
 */
public class ShikakushutokuIdoSoshitsuEditor implements IShikakushutokuIdoSoshitsuEditor {
    
    private final ShikakushutokuIdoSoshitsuItem joho;
    
    /**
     * コンストラクタです。
     * @param joho 一覧表証発行者Entityリストです
     */
    public ShikakushutokuIdoSoshitsuEditor(ShikakushutokuIdoSoshitsuItem joho) {
        this.joho = joho;
    }

    /**
     * 被保険者証発行一覧表editです。
     * @param source 被保険者証発行一覧表Source
     * @return 要介護認定業務進捗状況一覧表
     */
    @Override
    public ShikakushutokuIdoSoshitsuReportSource edit(ShikakushutokuIdoSoshitsuReportSource source) {
        return editBody(source);
    }
    
    private ShikakushutokuIdoSoshitsuReportSource editBody(ShikakushutokuIdoSoshitsuReportSource source) {
        source.ninshoshaYakushokuMei = joho.getNinshoshaYakushokuMei();
        source.birthYMD1 = joho.getBirthYMD1();
        source.hihokenshaJusho = joho.getHihokenJusho();
        source.hihokenKatakaki = joho.getHihokenKatakaki();
        source.hihokenshaName1 = joho.getHihokenshaName1();
        source.hihokenshaNameKana1 = joho.getHihokenshaNameKana1();
        source.hihokenshaNo1 = joho.getHihokenshaNo1();
        source.seibetsu1 = joho.getSeibetsu1();
        source.setainushiName = joho.getSetainushiName();
        source.zokugara1 = joho.getZokugara1();
        return source;
    }
    
}
