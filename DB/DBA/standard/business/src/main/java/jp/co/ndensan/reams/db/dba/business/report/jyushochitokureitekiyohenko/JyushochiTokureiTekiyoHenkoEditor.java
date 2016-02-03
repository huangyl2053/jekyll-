/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.jyushochitokureitekiyohenko;

import jp.co.ndensan.reams.db.dba.entity.report.jyushochitokureitekiyohenko.JyushochiTokureiTekiyoHenkoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護保険住所地特例適用・変更・終了届のEditorです。
 */
    public class JyushochiTokureiTekiyoHenkoEditor implements IJyushochiTokureiTekiyoHenkoEditor {
    
    private final JyushochiTokureiTekiyoHenkoItem joho;
    
    /**
     * コンストラクタです。
     * @param joho 一覧表証発行者Entityリストです
     */
    public JyushochiTokureiTekiyoHenkoEditor(JyushochiTokureiTekiyoHenkoItem joho) {
        this.joho = joho;
    }

    /**
     * 被保険者証発行一覧表editです。
     * @param source 被保険者証発行一覧表Source
     * @return 要介護認定業務進捗状況一覧表
     */
    @Override
    public JyushochiTokureiTekiyoHenkoReportSource edit(JyushochiTokureiTekiyoHenkoReportSource source) {
        return editBody(source);
    }
    
    private JyushochiTokureiTekiyoHenkoReportSource editBody(JyushochiTokureiTekiyoHenkoReportSource source) {
        source.ninshoshaYakushokuMei = joho.getNinshoshaYakushokuMei();
        source.hihokenshaNo = joho.getHihokenshaNo();
        source.hihokenshaNameKana = joho.getHihokenshaNameKana();
        source.hihokenshaName = joho.getHihokenshaName();
        source.birthYMD = joho.getBirthYMD();
        // TODO 内部QA：643 (性別の設定不明です)
        source.seibetsu = joho.getSeibetsu();
        // TODO 内部QA：635 (連番の設定不明です)
        source.remban = new RString("0001");
        return source;
    }
    
}
