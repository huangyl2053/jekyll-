/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kaigojuryoininkeiyakujigyoshaichirahyo;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigojuryoininkeiyakujigyoshaichirahyo.KaigoJuryoininKeiyakuJigyoshaIchirahyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.juryoininjigyoshaichiran.JuryoIninJigyoshaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBCMN32001_受領委任契約事業者一覧表Reportのインターフェースクラスです。
 *
 * @reamsid_L DBC-2110-040 liuxiaoyu
 */
public class JuryoIninJigyoshaIchiranBodyEditor implements IJuryoIninJigyoshaIchiranEditor {

    private final KaigoJuryoininKeiyakuJigyoshaIchirahyoEntity 帳票出力対象データ;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ KaigoJuryoininKeiyakuJigyoshaIchirahyoEntity
     */
    public JuryoIninJigyoshaIchiranBodyEditor(
            KaigoJuryoininKeiyakuJigyoshaIchirahyoEntity 帳票出力対象データ) {
        this.帳票出力対象データ = 帳票出力対象データ;
    }

    @Override
    public JuryoIninJigyoshaIchiranSource edit(JuryoIninJigyoshaIchiranSource source) {
        source.listUpper_1 = 帳票出力対象データ.get事業者番号();
        if (帳票出力対象データ.get事業者名称カナ() != null) {
            source.listUpper_2 = 帳票出力対象データ.get事業者名称カナ().getColumnValue();
        }
        if (帳票出力対象データ.get所在地郵便番号() != null) {
            source.listUpper_3 = 帳票出力対象データ.get所在地郵便番号().getColumnValue();
        }
        if (帳票出力対象データ.get所在地上段() != null) {
            source.listUpper_4 = 帳票出力対象データ.get所在地上段().getColumnValue();
        }
        if (帳票出力対象データ.get契約開始日() != null) {
            source.listUpper_5 = new RString(帳票出力対象データ.get契約開始日().toString());
        }
        source.listUpper_6 = 帳票出力対象データ.get振込先金融機関();
        source.listUpper_7 = 帳票出力対象データ.get振込先口座番号();
        if (帳票出力対象データ.get事業者名称() != null) {
            source.listLower_1 = 帳票出力対象データ.get事業者名称().getColumnValue();
        }
        if (帳票出力対象データ.get所在地下段() != null) {
            source.listLower_2 = 帳票出力対象データ.get所在地下段().getColumnValue();
        }
        source.listLower_3 = 帳票出力対象データ.get契約種別();
        source.listLower_4 = 帳票出力対象データ.get振込先支店名();
        if (帳票出力対象データ.get振込先名義人名() != null) {
            source.listLower_5 = 帳票出力対象データ.get振込先名義人名().getColumnValue();
        }
        return source;
    }
}
