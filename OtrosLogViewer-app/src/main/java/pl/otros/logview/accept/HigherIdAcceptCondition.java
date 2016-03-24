/*******************************************************************************
 * Copyright 2011 Krzysztof Otrebski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package pl.otros.logview.accept;

import pl.otros.logview.api.LogData;
import pl.otros.logview.api.LogDataTableModel;

import javax.swing.*;

public class HigherIdAcceptCondition extends SelectionAwareAcceptCondition {


    public HigherIdAcceptCondition(JTable jTable, LogDataTableModel dataTableModel) {
        super(jTable, dataTableModel);
    }

    @Override
    protected void init() {
        name = "Higher id";
    }

    protected int id;

    @Override
    public boolean accept(LogData data) {
        return data.getId() > id;
    }



    @Override
    protected void updateAfterSelection() {
        int selectedRow = jTable.getSelectedRow();
        id = dataTableModel.getLogData(jTable.convertRowIndexToModel(selectedRow)).getId();
        name = "Id higher than " +id;
        description = name;

    }
}
