/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.kaigohokentokubetukaikeikeirijyokyoregist;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.JigyoHokokuNenpoShoriName;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 処理日付管理マスタのエンティティです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoHokenShoriDateKanriEntity {

    private SubGyomuCode サブ業務コード;
    private LasdecCode 市町村コード;
    private JigyoHokokuNenpoShoriName 処理名;
    private RString 処理枝番;
    private FlexibleYear 年度;
    private RString 年度内連番;
    private FlexibleDate 基準年月日;
    private RDateTime 基準日時;
    private FlexibleDate 対象開始年月日;
    private FlexibleDate 対象終了年月日;
    private YMDHMS 対象開始日時;
    private YMDHMS 対象終了日時;

    public KaigoHokenShoriDateKanriEntity() {
    }

    public KaigoHokenShoriDateKanriEntity(SubGyomuCode サブ業務コード, LasdecCode 市町村コード,
            JigyoHokokuNenpoShoriName 処理名, RString 処理枝番, FlexibleYear 年度, RString 年度内連番,
            FlexibleDate 基準年月日, RDateTime 基準日時, FlexibleDate 対象開始年月日,
            FlexibleDate 対象終了年月日, YMDHMS 対象開始日時, YMDHMS 対象終了日時) {
        this.サブ業務コード = サブ業務コード;
        this.市町村コード = 市町村コード;
        this.処理名 = 処理名;
        this.処理枝番 = 処理枝番;
        this.年度 = 年度;
        this.年度内連番 = 年度内連番;
        this.基準年月日 = 基準年月日;
        this.基準日時 = 基準日時;
        this.対象開始年月日 = 対象開始年月日;
        this.対象終了年月日 = 対象終了年月日;
        this.対象開始日時 = 対象開始日時;
        this.対象終了日時 = 対象終了日時;
    }

}
