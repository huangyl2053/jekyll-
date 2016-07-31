/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 処理結果リスト一時TBL
 *
 * @reamsid_L DBC-0980-302 surun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT0002KokuhorenTorikomiErrorTempEntity {

    /**
     * コンストラクタです。
     */
    public DbWT0002KokuhorenTorikomiErrorTempEntity() {
        this.エラー区分 = RString.EMPTY;
        this.キー1 = RString.EMPTY;
        this.キー2 = RString.EMPTY;
        this.キー3 = RString.EMPTY;
        this.キー4 = RString.EMPTY;
        this.キー5 = RString.EMPTY;
        this.被保険者カナ氏名 = RString.EMPTY;
        this.被保険者氏名 = RString.EMPTY;
        this.備考 = RString.EMPTY;
    }

    private RString エラー区分;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private HihokenshaNo 被保険者番号;
    private RString キー1;
    private RString キー2;
    private RString キー3;
    private RString キー4;
    private RString キー5;
    private RString 被保険者カナ氏名;
    private RString 被保険者氏名;
    private RString 備考;

}
